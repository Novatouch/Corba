package test;

import LivreEnLigne.Controleur;
import LivreEnLigne.Fournisseur;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class testFlush {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// resolution mandataire
		Debug.afficherLog("info","Résolution du controleur auprès du serveur de nommage");
		Controleur controleur = corbaManager.resolveObjetControleur("controleur");
		
		Debug.afficherLog("info","Résolution des fournisseurs auprès du serveur de nommage");
		Fournisseur fournisseur = corbaManager.resolveObjetFournisseur("fournisseur1");
		Debug.afficherLog("info","flush des listes");
		
		fournisseur.flush();
		controleur.flush();
	}
}
