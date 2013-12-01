package test;

import commun.Debug;

import LivreEnLigne.Banque;
import LivreEnLigne.Controleur;
import LivreEnLigne.ExceptionMoneyTransferRefused;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Mandataire;
import corba.CorbaLivreEnLigne;

public class testControleur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// resolution mandataire
		Debug.afficherLog("info","Résolution du controleur auprès du serveur de nommage");
		Controleur controleur = corbaManager.resolveObjetControleur("controleur");
		
		Debug.afficherLog("info","test enregistrement de commande");
		controleur.enregistrerAchat("plop", "titre1", "auteur1", "fourn");

	}
}
