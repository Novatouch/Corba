package fournisseur;

import LivreEnLigne.Banque;
import LivreEnLigne.Controleur;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionMoneyTransferRefused;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.FournisseurPOA;
import LivreEnLigne.InfoBancaires;
import LivreEnLigne.Lecteur;
import LivreEnLigne.LivreChiffre;

import commun.Commande;
import commun.Debug;
import commun.Livre;

import corba.CorbaLivreEnLigne;

public class ServantFournisseur extends FournisseurPOA {

	private CorbaLivreEnLigne corbaManager = null;
	private String nomFournisseur = null;
	private Catalogue catalogue = null;
	private ListeTelechargement listeTelechargement = null;
	private ListeCommande listeCommande = null;
	private Banque iorBanque = null;
	private String nomBanque = null;
	private Controleur iorControleur = null;
	private String nomControleur = null;
	
	//private Fournisseur iorFournisseur = null;
	
	ServantFournisseur(String pNomFournisseur, CorbaLivreEnLigne pCorbaManager, Catalogue pCatalogue, 
			ListeTelechargement pListeTelechargement, ListeCommande pListeCommande, String pNomBanque, 
			String pNomControleur){
		
		corbaManager = pCorbaManager;
		nomFournisseur = pNomFournisseur;
		catalogue = pCatalogue;
		listeTelechargement = pListeTelechargement;
		listeCommande = pListeCommande;
		nomBanque = pNomBanque;
		nomControleur = pNomControleur;
		iorBanque = corbaManager.resolveObjetBanque(pNomBanque);
		iorControleur = corbaManager.resolveObjetControleur(pNomControleur);
		
	}

	@Override
	public float rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound {
		
		Debug.afficherLog("info","reception requete rechercher Livre : " + pTitre + " Auteur : " + pAuteur);
		return catalogue.rechercherPrix(pAuteur, pTitre);
	}



	@Override
	public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commander(String pTitre, String pAuteur, String pCompte, String pCode , String pNomAchetteur, Lecteur pIorAchetteur) throws ExceptionEchecCommande {
		
		Debug.afficherLog("info","reception requete commande");
		// vérifier existence livre dans le catalogue
		try {
			
			Debug.afficherLog("info","recherche du livre dans le catalogue");
			LivreCatalogue livre = catalogue.rechercherLivre(pAuteur, pTitre);
			
			// verifiez coordonnées bancaires
			try {
				Debug.afficherLog("info","verification coordonnees bancaires");
				
				iorBanque.verifierCoordonneesBancaires(pCompte, pCode);
				
				Debug.afficherLog("info","enregistrement de la commande sur le fournisseur");
				
				CommandeFournisseur commandeFournisseur = new CommandeFournisseur(pNomAchetteur, pIorAchetteur, livre);
				// ajouter la commande à la liste commande
				listeCommande.ajouterCommande(commandeFournisseur);
				
				// ajouter le livre à la liste des chiffrement
				Telechargement nouveauTelechargement = new Telechargement(commandeFournisseur);
				
				Debug.afficherLog("info","ajout du livre dans la liste des telechargement");
				listeTelechargement.ajouterTelechargement(nouveauTelechargement);
				
				Debug.afficherLog("info","enregistrement de la commande sur le controleur");
				
				// ajouteur la commande au controleur
				iorControleur.enregistrerAchat(pNomAchetteur, pTitre, pAuteur, nomFournisseur);
				
			} catch (ExceptionMoneyTransferRefused e) {
												
				throw new ExceptionEchecCommande("Le livre ne fait pas partie du catalogue");
			}
			
		} catch (ExceptionNoLivreFound e) {
			
			throw new ExceptionEchecCommande("Le livre ne fait pas partie du catalogue");
		}
	}

	@Override
	public LivreChiffre telechargerLivre(String pUtilisateur, Lecteur IorUtulisateur, String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		return null;
	}


}
