package banque;

import commun.Debug;

import LivreEnLigne.BanquePOA;
import LivreEnLigne.ExceptionMoneyTransferRefused;

public class ServantBanque extends BanquePOA {



	@Override
	public void verifierCoordonneesBancaires(String pCompte, String pCode)
			throws ExceptionMoneyTransferRefused {
		Debug.afficherLog("info","Reception demande verification compte, compte : " + pCompte + " code : " + pCode);
		Debug.afficherLog("info","demande acceptée");
		
	}

	
}
