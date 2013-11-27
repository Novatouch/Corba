package mandataire;

import corba.CorbaLivreEnLigne;

public class MandataireCorbaWorker implements Runnable{

	CorbaLivreEnLigne corbaManager = null;

	MandataireCorbaWorker(CorbaLivreEnLigne pCorbaManager){
		corbaManager = pCorbaManager;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		corbaManager.run();
	}

}
