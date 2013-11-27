package mandataire;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class MandataireMain {

	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		
		String nomServeur = "mandataire";
		
		// objet pour gérer Corba
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// liste des Fournisseurs
		ListeFournisseur listeFournisseur = new ListeFournisseur();
		
		
		// création du servant Mandataire
		Debug.afficherLog("info","création du servant Mandataire");
		ServantMandataire monMandataire = new ServantMandataire(listeFournisseur);
		
		// enregistrement serveur aupèrs du serveur de nommage
		Debug.afficherLog("info","enregistrement du servant Mandataire auprès du service de nommage");
		corbaManager.enregistrementServant(nomServeur, monMandataire);
		
		// Lancement MandataireCorbaWorker
		Debug.afficherLog("info","lancement du Thread MandataireCorbaWorker");
		Thread t1 = new Thread(new MandataireCorbaWorker(corbaManager));
		t1.start();
	}

}
