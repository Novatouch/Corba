package lecteur;

import java.util.ArrayList;

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
	Bibliotheque bibliothequePret;
	
	
	
	/**
	 * Constructeur de la classe 
	 * 
	 * 
	 * 
	 * @param pCorbaManager
     *           Objet corba faisant l'interface avec la partie corba.
     *           
	 * @param pBibliotheque
     *           Objet bibliothèque contenant les livres Achettés par le lecteur.
     *                    
	 * @param bibliothequePret
     *           Objet bibliothèquePret contenant les livres pretés par le lecteur.
     *           
	 * @param pNomMandataire
     *           nom du serveur mandataire.
     *           
	 * @param pNomControleur
     *           nom du serveur controleur.
     *               
	 */
	
	public InterfaceLivreEnLigne(CorbaLivreEnLigne pCorbaManager, Bibliotheque pBibliotheque, Bibliotheque bibliothequePret,
			String pNomMandataire, String pNomLecteur, String pNomControleur){
		
		corbaManager = pCorbaManager;
		// resolution iorMandataire
		Debug.afficherLog("info","Résolution du Mandataire auprès du serveur de nommage");
		iorMandataire = corbaManager.resolveObjetMandataire(pNomMandataire);
		iorControleur = corbaManager.resolveObjetControleur(pNomControleur);
		iorLecteur = corbaManager.resolveObjetLecteur(pNomLecteur);
		bibliotheque = pBibliotheque;
		bibliothequePret = bibliothequePret;
		nomLecteur = pNomLecteur;
	}
	
	
	/**
	 * fonction permettant de faire des recherches via le mandataire
	 * 
	 * @param pTitre
     *           titre de l'oeuvre.
     *           
	 * @param pAuteur
     *           nom de l'auteur.
     *           
     * @return  resultat
     * 			 instance de la classe InfoRecherche contient le prix et le nom du 
     * 			 fournisseur ainsi que son ior
     * 
     * @throws ExceptionNoLivreFound  
     *           
	 */
	
	public InfoRecherche rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound{
	
		InfoRecherche resultat = iorMandataire.rechercherLivre("titre1", "auteur1");
					
		return resultat;
	}
	

	/**
	 * fonction permettant de faire une comm
	 * 
	 * @param pTitre
     *           titre de l'oeuvre.
     *           
	 * @param pAuteur
     *           nom de l'auteur.
     *           
	 * @param pIorFournisseur
     *           ior du fournisseur.
     *           
	 * @param pNomFournisseur
     *           nom du fournisseur.         
     *           
	 * @param pCompte
     *           numero Compte.
     *           
	 * @param pCle
     *           numero cle compte.    
     *           
     *           
     * @throws ExceptionEchecCommande       
     *           
	 */
	
	public void commander(String pTitre, String pAuteur, Fournisseur pIorFournisseur, String pNomFournisseur, String pCompte, String pCode) throws ExceptionEchecCommande{
		LivreUtilisateur nouveauLivre = new LivreUtilisateur(pAuteur, pTitre, pNomFournisseur, pIorFournisseur);
		bibliotheque.ajouterLivre(nouveauLivre);
		Debug.afficherLog("info","InterfaceLivreEnLigne > ajout du livre dans la bibliothèque");
		
		pIorFournisseur.commander(pTitre, pAuteur, pCompte, pCode, nomLecteur, iorLecteur);
	}
	

	/**
	 * fonction permettant de Lire un Livre
	 * 
	 * @param pTitre
     *           titre de l'oeuvre.
     *           
	 * @param pAuteur
     *           nom de l'auteur.
     *           
	 * @param pIorFournisseur
     *           ior du fournisseur.
     *           
	 * @param pNomFournisseur
     *           nom du fournisseur.         
     *           
	 * @param pCompte
     *           numero Compte.
     *           
	 * @param pCle
     *           numero cle compte.    
     *           
     *           
     * @throws ExceptionAuthorizationFailed
     * 			le controleur n'a pas autorisé la lecture
     * 
     * @throws ExceptionLivreNotTelecharge  
     * 			le livre n'est pas encore téléchargé
     * 
     * @throws ExceptionPretEstTropOld 
     * 			le prêt à expiré
     * 
     * 
     * @throws ExceptionLivreIsEnCoursPret
     * 			le livre a été prêté
     * 
     * @return  Contenu du livre
     * 			           
	 */
	
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
	
	
	/**
	 * fonction permettant de prêter un Livre
	 * 
	 * @param pLivre
     *           livre à prêter.
     *           
	 * @param pUtilisateurEmprunteur
     *           nom de l'utilisateur preteur.
     *           
     * 
     * @throws ExceptionPretNotAllowed
     * 			le prêt n'a pas été autorisé
     * 
     * 			           
	 */
	
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
	
	
	/**
	 * fonction permettant d'annuler un prêt
	 * 
	 * @param pLivre
     *           livre à prêter.
     *                    
     * 
     * @throws ExceptionPretNotDeleted
     * 			le prêt n'a pas été supprimé
     * 
     * 			           
	 */

	public void annulerPreterLivre(LivreUtilisateur pLivre) throws ExceptionPretNotDeleted{
		
		// recup ior Fournisseur
		Fournisseur iorFournisseur = pLivre.getIorFournisseur();
		
		// requête au fournisseur pour supprimer le pret
		pLivre.setEstPrete(false);
		
		iorFournisseur.retirerPret(nomLecteur, pLivre.getNomEmprunteur(), pLivre.getIorEmprunteur(), pLivre.getTitre(), pLivre.getAuteur());
		
	}
	
	
	/**
	 * fonction permettant de récupérer les livres achettés
	 * Remarque: Il est possible que certains livre ne soit pas encore téléchargés.
	 * 
     * @return     ArrayList<LivreUtilisateur>
     * 			             
     * 
     * @throws ExceptionPretNotDeleted
     * 			le prêt n'a pas été supprimé
     * 			           
	 */
	
	public ArrayList<LivreUtilisateur> getLivreAchette(){
		
		return bibliotheque.getLivreAchette();
	}
	
	
	/**
	 * fonction permettant de récupérer les livres prètés
	 * 
	 * 
     * @return     ArrayList<LivreUtilisateurPret>
     * 			             
     * 
     * @throws ExceptionPretNotDeleted
     * 			le prêt n'a pas été supprimé
     * 			           
	 */
	
	public ArrayList<LivreUtilisateurPret> getLivreEmprunte(){
		
		return bibliotheque.getLivreEmprunte();
	}
}
