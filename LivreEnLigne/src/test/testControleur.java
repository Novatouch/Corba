package test;

import commun.Debug;


import LivreEnLigne.Controleur;
import LivreEnLigne.ExceptionAuthorizationFailed;

import LivreEnLigne.ExceptionPretNotSaved;

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

		Debug.afficherLog("info","test verification Lecture livre");
		try {
			controleur.verifierAutorisation("titre1", "auteur1", "plop", "fourn");
			Debug.afficherLog("info","autorisation ok");
			
			Debug.afficherLog("info","test enregistrement de pret");
			try {
				controleur.enregistrerPret("plop", "plop2", "titre1", "auteur1", "fourn");
				Debug.afficherLog("info","enregistrement pret ok");
				
				Debug.afficherLog("info","test supression autorisation livre Pret");
				controleur.retirerPret("plop", "plop2", "fourn", "titre1", "auteur1");
				
				Debug.afficherLog("info","test verification Lecture livre Pret");
				
				try {
					controleur.verifierAutorisationPret("titre1", "auteur1", "plop", "plop2", "fourn");
					Debug.afficherLog("info","autorisation Pret ok");
				
				} catch (ExceptionAuthorizationFailed e) {
					Debug.afficherLog("error","autorisation Pret nok");
				}
				
			} catch (ExceptionPretNotSaved e) {
			
				Debug.afficherLog("info","enregistrement pret nok");
			}
			
		} catch (ExceptionAuthorizationFailed e) {
			Debug.afficherLog("error","autorisation nok");
		}
	}
}
