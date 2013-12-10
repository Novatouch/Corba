package lecteur;

import LivreEnLigne.Controleur;
import LivreEnLigne.ExceptionAuthorizationFailed;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.ExceptionPretNotAllowed;
import LivreEnLigne.ExceptionPretNotDeleted;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Lecteur;
import LivreEnLigne.Mandataire;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class InterfaceLivreEnLigne {

	Mandataire iorMandataire;
	CorbaLivreEnLigne corbaManager;
	String nomLecteur;
	Lecteur iorLecteur;
	Controleur iorControleur;
	Bibliotheque bibliotheque;
	
	public InterfaceLivreEnLigne(CorbaLivreEnLigne pCorbaManager, Bibliotheque pBibliotheque, String pNomMandataire, String pNomLecteur, String pNomControleur){
		
		corbaManager = pCorbaManager;
		// resolution iorMandataire
		Debug.afficherLog("info","Résolution du Mandataire auprès du serveur de nommage");
		iorMandataire = corbaManager.resolveObjetMandataire(pNomMandataire);
		iorControleur = corbaManager.resolveObjetControleur(pNomControleur);
		iorLecteur = corbaManager.resolveObjetLecteur(pNomLecteur);
		bibliotheque = pBibliotheque;
		nomLecteur = pNomLecteur;
	}
	
	public InfoRecherche rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound{
	
		InfoRecherche resultat = iorMandataire.rechercherLivre("titre1", "auteur1");
					
		return resultat;
	}
	

	
	public void commander(String pTitre, String pAuteur, Fournisseur pIorFournisseur, String pNomFournisseur, String pCompte, String pCode) throws ExceptionEchecCommande{
		LivreUtilisateur nouveauLivre = new LivreUtilisateur(pAuteur, pTitre, pNomFournisseur, pIorFournisseur);
		bibliotheque.ajouterLivre(nouveauLivre);
		Debug.afficherLog("info","InterfaceLivreEnLigne > ajout du livre dans la bibliothèque");
		
		pIorFournisseur.commander(pTitre, pAuteur, pCompte, pCode, nomLecteur, iorLecteur);
	}
	
	public String LireLivre(LivreUtilisateurVirtual pLivre) throws ExceptionAuthorizationFailed, ExceptionLivreNotTelecharge, ExceptionPretEstTropOld, ExceptionLivreIsEnCoursPret{
		
		// verifie si le livre peut être lu
		pLivre.lecturePossible();
		
		// verifié si la lecture à été autorisée par le controleur
		if(pLivre.getLectureAutorisee() != true){
			
			// demande autorisation auprès controleur
			if (pLivre instanceof LivreUtilisateurPret){
	
				LivreUtilisateurPret livre = (LivreUtilisateurPret) pLivre;
				
				iorControleur.verifierAutorisationPret(livre.getTitre(), livre.getAuteur(), livre.getNomProprietaire(), nomLecteur, livre.getNomFournisseur());
			} else {
				
				
				iorControleur.verifierAutorisation(pLivre.getTitre(), pLivre.getAuteur(), nomLecteur, pLivre.getNomFournisseur());
			}
			pLivre.setLectureAutorisee(true);
		}
		
		return pLivre.dechiffrementLivre();
	}
	
	
	public void preterLivre(LivreUtilisateur pLivre, String pUtilisateurEmprunteur) throws ExceptionPretNotAllowed{
		
		// recupérer iorFournisseur
		Fournisseur iorFournisseur = pLivre.getIorFournisseur();
		
		// récupérer ior utilisateur emprunteur
		Lecteur iorUtilisateurEmprunteur = corbaManager.resolveObjetLecteur(pUtilisateurEmprunteur);
		
		// mettre a jour info livre
		pLivre.setNomEmprunteur(pUtilisateurEmprunteur);
		pLivre.setIorEmprunteur(iorUtilisateurEmprunteur);
		pLivre.setEstPrete(true);
		
		iorFournisseur.creerPret(nomLecteur, pUtilisateurEmprunteur, iorUtilisateurEmprunteur, pLivre.getTitre(), pLivre.getAuteur());
	}
	
	public void annulerPreterLivre(LivreUtilisateur pLivre) throws ExceptionPretNotDeleted{
		
		// recup ior Fournisseur
		Fournisseur iorFournisseur = pLivre.getIorFournisseur();
		
		// requête au fournisseur pour supprimer le pret
		pLivre.setEstPrete(false);
		
		iorFournisseur.retirerPret(nomLecteur, pLivre.getNomEmprunteur(), pLivre.getIorEmprunteur(), pLivre.getTitre(), pLivre.getAuteur());
		
	}
}
