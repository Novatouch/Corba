package fournisseur;

import LivreEnLigne.Fournisseur;
import LivreEnLigne.Mandataire;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class FournisseurMain1 {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		
		String nomServeur = "fournisseur1";
		String nomMandataire = "mandataire";
		String nomBanque = "banque";
		String nomControleur = "controleur";
		
		Catalogue catalogue = new Catalogue();
		ListeTelechargement listeTelechargement = new ListeTelechargement();
		ListeTelechargement listeTelechargementPret = new ListeTelechargement();
		ListeCommande listeCommande = new ListeCommande();
		
		Debug.afficherLog("info","créations des livres");
		
		// remplissage du catalogue
		LivreCatalogue livre1 = new LivreCatalogue("Cédric Teyssié", "J'ai testé la QOS sur ma femme", "1er conseil -> ne jamais essayer", (float) 3.0, true);
		LivreCatalogue livre2 = new LivreCatalogue("Patrice Torguet", "Le Corba pour les nuls et les petits cons", "demerdez-vous !", (float) 10.0, true);
		LivreCatalogue livre3 = new LivreCatalogue("auteur1", "titre1", "contenu1", (float) 10.0, true);
		LivreCatalogue livre4 = new LivreCatalogue("auteur2", "titre2", "contenu2", (float) 10.0, true);
		
		Debug.afficherLog("info","ajout des Livres au catalogue");
		
		catalogue.ajouterLivre(livre1);
		catalogue.ajouterLivre(livre2);
		catalogue.ajouterLivre(livre3);
		catalogue.ajouterLivre(livre4);

		
		// objet pour gérer Corba
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// création du servant Mandataire
		Debug.afficherLog("info","création du servant Fournisseur");
		ServantFournisseur monFournisseur = new ServantFournisseur(nomServeur, corbaManager, catalogue, listeTelechargement, listeTelechargementPret, listeCommande, nomBanque, nomControleur);
		
		// enregistrement serveur auprès du serveur de nommage
		Debug.afficherLog("info","enregistrement du servant Fournisseur auprès du service de nommage");
		corbaManager.enregistrementServant(nomServeur, monFournisseur);
		
		Debug.afficherLog("info","Enregistrement du Fournisseur auprès du mandataire");
		// enregistrement du servant auprès du mandataire
		Fournisseur iorFournisseur = corbaManager.resolveObjetFournisseur(nomServeur);
		
		Mandataire iorMandataire = corbaManager.resolveObjetMandataire(nomMandataire);
		
		iorMandataire.enregistrementFournisseur(nomServeur, iorFournisseur);
		
		try {
			Thread.sleep(1);
			
			// Lancement FournisseurCorbaWorker
			Debug.afficherLog("info","lancement du Thread FournisseurCorbaWorker");
			Thread t1 = new Thread(new FournisseurCorbaWorker(corbaManager));
			t1.start();
			
			// Lancement thread chiffrement
			Debug.afficherLog("info","lancement du Thread ChiffrementWorkerAchat");
			Thread t2 = new Thread(new ChiffrementWorkerAchat(listeTelechargement, nomServeur, iorFournisseur));
			t2.start();
			
			
			Debug.afficherLog("info","lancement du Thread ChiffrementWorkerPret");
			Thread t3 = new Thread(new ChiffrementWorkerPret(listeTelechargementPret, nomServeur, iorFournisseur));
			t3.start();
			
			
			// Lancement thread modification contenu Livre
			Debug.afficherLog("info","lancement du Thread ChangementContenuWorker");
			Thread t4 = new Thread(new ChangementContenuWorker(nomServeur, listeTelechargementPret, listeTelechargement, catalogue, listeCommande));
			t4.start();
			
		} catch (InterruptedException e) {
			
			Debug.afficherLog("error"," Erreur tragique le thread n'a pu s'endormir");
		}
	}
}
