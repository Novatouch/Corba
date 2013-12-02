package lecteur;

import corba.CorbaLivreEnLigne;

public class LecteurCorbaWorker implements Runnable {
	
	private CorbaLivreEnLigne corbaManager = null;

	public LecteurCorbaWorker(CorbaLivreEnLigne pCorbaManager) {

		this.corbaManager = pCorbaManager;
	}

	@Override
	public void run() {
		
		corbaManager.run();
	}
}
