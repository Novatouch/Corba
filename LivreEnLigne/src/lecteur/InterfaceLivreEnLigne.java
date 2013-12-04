package lecteur;

import LivreEnLigne.Controleur;
import LivreEnLigne.ExceptionAuthorizationFailed;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
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
	
	public InterfaceLivreEnLigne(String pMandataire, CorbaLivreEnLigne pCorbaManager, Bibliotheque pBibliotheque, String pLecteur, Lecteur pIorLecteur, String pNomControleur){
		
		corbaManager = pCorbaManager;
		// resolution iorMandataire
		Debug.afficherLog("info","Résolution du Mandataire auprès du serveur de nommage");
		iorMandataire = corbaManager.resolveObjetMandataire(pMandataire);
		iorControleur = corbaManager.resolveObjetControleur(pNomControleur);
		iorLecteur = pIorLecteur;
		bibliotheque = pBibliotheque;
	}
	
	public InfoRecherche rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound{
	
		InfoRecherche resultat = iorMandataire.rechercherLivre("titre1", "auteur1");
					
		return resultat;
	}
	
	public void commander(String pTitre, String pAuteur, Fournisseur pIorFournisseur, String pNomFournisseur, String pCompte, String pCode) throws ExceptionEchecCommande{
		
		pIorFournisseur.commander(pTitre, pAuteur, pCompte, pCode, nomLecteur, iorLecteur);
		
		LivreUtilisateur nouveauLivre = new LivreUtilisateur(pAuteur, pTitre, pNomFournisseur, pIorFournisseur);
		bibliotheque.ajouterLivre(nouveauLivre);
	}
	
	public String LireLivre(LivreUtilisateur pLivre) throws ExceptionAuthorizationFailed, ExceptionLivreNotTelecharge{
		
		if(pLivre.getEstTelecharger() == false){
			throw new ExceptionLivreNotTelecharge();
		}
		
		if(pLivre.getLectureAutorisee() != true){
			
			// demande autorisation auprès controleur
			iorControleur.verifierAutorisation(pLivre.getTitre(), pLivre.getAuteur(), nomLecteur, pLivre.getNomFournisseur());
			
			pLivre.setLectureAutorisee(true);
		}
		
		return pLivre.dechiffrementLivre();
	}
}
