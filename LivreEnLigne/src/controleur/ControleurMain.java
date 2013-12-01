package controleur;

import banque.ServantBanque;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class ControleurMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String nomServeur = "controleur";
		Debug.afficherLog("info","Lancement programme controleur");
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		ListeEnregistrement liste = new ListeEnregistrement();
		
		ServantControleur monControleur = new ServantControleur(liste);
		
		Debug.afficherLog("info","Enregistrement du servant Controleur auprès du naming service");
		corbaManager.enregistrementServant(nomServeur, monControleur);
		
		corbaManager.run();

	}
}
