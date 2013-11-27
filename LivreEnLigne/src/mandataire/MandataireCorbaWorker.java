package mandataire;

import corba.CorbaLivreEnLigne;

public class MandataireCorbaWorker implements Runnable{

	private CorbaLivreEnLigne corbaManager = null;

	public MandataireCorbaWorker(CorbaLivreEnLigne pCorbaManager){
		corbaManager = pCorbaManager;
	}
	
	
	@Override
	public void run() {
		
		corbaManager.run();
	}

}
