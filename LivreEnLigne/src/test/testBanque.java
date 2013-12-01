package test;

import commun.Debug;

import LivreEnLigne.Banque;
import LivreEnLigne.ExceptionMoneyTransferRefused;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Mandataire;
import corba.CorbaLivreEnLigne;

public class testBanque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// resolution mandataire
		Debug.afficherLog("info","Résolution de la banque auprès du serveur de nommage");
		Banque banque = corbaManager.resolveObjetBanque("banque");
		
		Debug.afficherLog("info","test de validation de coordonnées bancaire");

		try {
			banque.verifierCoordonneesBancaires("bla", "bla");
			
			Debug.afficherLog("info","verif OK");
		} catch (ExceptionMoneyTransferRefused e) {
			// TODO Auto-generated catch block
			Debug.afficherLog("info","verif NOK");
		}	
	}

}
