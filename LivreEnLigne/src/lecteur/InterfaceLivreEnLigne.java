package lecteur;

import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.InfoBancaires;
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
	Bibliotheque bibliotheque;
	
	public InterfaceLivreEnLigne(String pMandataire, CorbaLivreEnLigne pCorbaManager, Bibliotheque pBibliotheque, String pLecteur, Lecteur pIorLecteur){
		
		corbaManager = pCorbaManager;
		// resolution iorMandataire
		Debug.afficherLog("info","Résolution du Mandataire auprès du serveur de nommage");
		iorMandataire = corbaManager.resolveObjetMandataire(pMandataire);
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
	
	// commander(pTitre: String, pAuteur: String, pFournisseur: Fournisseur)
}