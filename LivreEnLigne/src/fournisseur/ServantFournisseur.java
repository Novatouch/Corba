package fournisseur;

import LivreEnLigne.Banque;
import LivreEnLigne.Controleur;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionMoneyTransferRefused;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.ExceptionPretNotAllowed;
import LivreEnLigne.ExceptionPretNotSaved;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.FournisseurPOA;
import LivreEnLigne.Lecteur;
import LivreEnLigne.LivreChiffre;

import commun.Commande;
import commun.Debug;
import commun.ExceptionLivreNotPretable;

import corba.CorbaLivreEnLigne;

public class ServantFournisseur extends FournisseurPOA {

	private CorbaLivreEnLigne corbaManager = null;
	private String nomFournisseur = null;
	private Catalogue catalogue = null;
	private ListeTelechargement listeTelechargement = null;
	private ListeTelechargement listeTelechargementPret = null;
	private ListeCommande listeCommande = null;
	private Banque iorBanque = null;
	private String nomBanque = null;
	private Controleur iorControleur = null;
	private Fournisseur iorFournisseur = null;
	private String nomControleur = null;
	
	//private Fournisseur iorFournisseur = null;
	
	ServantFournisseur(String pNomFournisseur, CorbaLivreEnLigne pCorbaManager, Catalogue pCatalogue, 
			ListeTelechargement pListeTelechargement, ListeTelechargement pListeTelechargementPret, ListeCommande pListeCommande, String pNomBanque, 
			String pNomControleur){
		
		corbaManager = pCorbaManager;
		nomFournisseur = pNomFournisseur;
		catalogue = pCatalogue;
		listeTelechargement = pListeTelechargement;
		listeTelechargementPret = pListeTelechargementPret;
		listeCommande = pListeCommande;
		nomBanque = pNomBanque;
		nomControleur = pNomControleur;
		iorBanque = corbaManager.resolveObjetBanque(pNomBanque);
		iorControleur = corbaManager.resolveObjetControleur(pNomControleur);
		iorFournisseur = corbaManager.resolveObjetFournisseur(pNomFournisseur);
	}

	@Override
	public float rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound {
		
		Debug.afficherLog("info","reception requete rechercher Livre : " + pTitre + " Auteur : " + pAuteur);
		return catalogue.rechercherPrix(pAuteur, pTitre);
	}





	@Override
	public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, Lecteur pIorUtilisateurEmprunteur,String pTitre, String pAuteur) {
		
		Debug.afficherLog("info","servantFournisseur > retirerPret : reception requete");

		try {
			// recherche de la commande
			Debug.afficherLog("info","servantFournisseur > retirerPret : recherche commande");
			Commande commande = listeCommande.rechercherCommande(pTitre, pAuteur, pUtilisateurPreteur);
			
			// mise a jour des champs
			commande.setEstPrete(false);
			
			Debug.afficherLog("info","servantFournisseur > retirerPret : envoi requete au controleur");
			// appel au controleur
			iorControleur.retirerPret(pUtilisateurPreteur, pUtilisateurEmprunteur, nomFournisseur, pTitre, pAuteur);
			
			// appel au lecteur emprunteur
			Debug.afficherLog("info","servantFournisseur > retirerPret : envoi requete à l'utilisateur emprunteur");
			//pIorUtilisateurEmprunteur.(pTitre, pAuteur, pUtilisateurPreteur, nomFournisseur, pIorFournisseur);
			pIorUtilisateurEmprunteur.retirerPret(pTitre, pAuteur, pUtilisateurPreteur);
			
		} catch (ExceptionNoCommandeInList e) {
			Debug.afficherLog("error","servantFournisseur > retirerPret : recherche commande a échouée");
		}
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
	public LivreChiffre telechargerLivre(String pTitre, String pAuteur, String pUtilisateur){
		
		// recupération de l'objet téléchargement lié à cet utilisateur et à sa commande
		Telechargement objetTelechargement = listeTelechargement.rechercherTelechargement(pTitre + pAuteur + pUtilisateur);
		
		// mise à jour de l'objet
		objetTelechargement.setaEnvoyer(false);
		
		// suppression de l'objet de la liste
		listeTelechargement.supprimerTelechargement(objetTelechargement);
		
		// envoie du contenu chiffré au client, ainsi que la clée
		return objetTelechargement.getLivreChiffre();
	}



	@Override
	public void creerPret(String pUtilisateurPreteur,
			String pUtilisateurEmprunteur, Lecteur pIorUtilisateurEmprunteur,
			String pTitre, String pAuteur) throws ExceptionPretNotAllowed {
		
		Debug.afficherLog("info","reception requete creerPret");
		// rechercher la commande pour la modifier
		try {
			
			Debug.afficherLog("info","recherche de la commande dans la base");
			CommandeFournisseur commande = listeCommande.rechercherCommande(pTitre, pAuteur, pUtilisateurPreteur);
			
			
			try {
				Debug.afficherLog("info","verifier que le livre n'est pas en cours de pret");
				commande.estPretable();
				
				// mettre à jour la commande
				commande.setPreteur(pUtilisateurPreteur);
				commande.setIorEmprunteur(pIorUtilisateurEmprunteur);
				commande.setDebutPret();
				commande.setEstPrete(true);
				
				
				// ajouter le livre dans la listeTelechargementPreteur
				Debug.afficherLog("info","ajout du livre à la liste de TelechergementPret");
				
				Telechargement nouveauTelechargement = new Telechargement(commande);
				
				Debug.afficherLog("info","ajout du livre dans la liste des telechargement");
				listeTelechargementPret.ajouterTelechargement(nouveauTelechargement);
				
				// avertir le controleur
				Debug.afficherLog("info","enregistrement du pret auprès du controleur");
				try {
					iorControleur.enregistrerPret(pUtilisateurPreteur, pUtilisateurEmprunteur, pTitre, pAuteur, nomFournisseur);
			
				} catch (ExceptionPretNotSaved e) {
					// pret rejeté par le controleur
					Debug.afficherLog("error","pret rejeté par le controleur");
					throw new ExceptionPretNotAllowed();
				}
		
			} catch (ExceptionLivreNotPretable e) {
				// livre en cours de pret
				Debug.afficherLog("error","livre en coursde pret pour le même achetteur");
				throw new ExceptionPretNotAllowed();
			}
			
		} catch (ExceptionNoCommandeInList e) {
			
			// commande introuvable
			Debug.afficherLog("error","commande introuvable auprès du controleur");
			throw new ExceptionPretNotAllowed();
		}
		
	}

	@Override
	public void flush() {
		listeTelechargementPret.flush();
		listeTelechargement.flush();
		listeCommande.flush();
	}

	@Override
	public LivreChiffre telechargerLivrePret(String pTitre, String pAuteur,
			String pUtilisateur, String pUtilisateurEmprunteur) {
		// recupération de l'objet téléchargement lié à cet utilisateur et à sa commande
		Telechargement objetTelechargement = listeTelechargementPret.rechercherTelechargement(pTitre + pAuteur + pUtilisateur);
		
		// mise à jour de l'objet
		objetTelechargement.setaEnvoyer(false);
		
		// suppression de l'objet de la liste
		listeTelechargementPret.supprimerTelechargement(objetTelechargement);
		
		// envoie du contenu chiffré au client, ainsi que la clée
		return objetTelechargement.getLivreChiffre();
	}
}
