package mandataire;

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
		ServantMandataire monMandataire = new ServantMandataire(listeFournisseur);
		
		// enregistrement serveur aupèrs du serveur de nommage
		corbaManager.enregistrementServant(nomServeur, monMandataire);
		
		// Lancement MandataireCorbaWorker
		Thread t1 = new Thread(new MandataireCorbaWorker(corbaManager));
		t1.start();
	}

}
