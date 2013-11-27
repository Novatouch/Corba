package fournisseur;

import corba.CorbaLivreEnLigne;

public class FournisseurCorbaWorker implements Runnable{

	private CorbaLivreEnLigne corbaManager = null;

	public FournisseurCorbaWorker(CorbaLivreEnLigne pCorbaManager) {
		super();
		this.corbaManager = pCorbaManager;
	}

	@Override
	public void run() {
		
		corbaManager.run();
	}
}
