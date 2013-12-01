package banque;

import commun.Debug;
import corba.CorbaLivreEnLigne;
import fournisseur.ServantFournisseur;

public class BanqueMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nomServeur = "banque";
		Debug.afficherLog("info","Lancement programme banque");
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		ServantBanque maBanque = new ServantBanque();
		
		Debug.afficherLog("info","Enregistrement du servant auprès du naming service");
		corbaManager.enregistrementServant(nomServeur, maBanque);
		
		corbaManager.run();
	}

}
