package test;

import commun.Debug;

import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Mandataire;
import corba.CorbaLivreEnLigne;

public class testMandataire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// resolution mandataire
		Debug.afficherLog("info","Résolution du Mandataire auprès du serveur de nommage");
		Mandataire mandataire = corbaManager.resolveObjetMandataire("mandataire");
		
		Debug.afficherLog("info","test d'une recherche aupèrs du mandataire");
		
		try {
			InfoRecherche resultat = mandataire.rechercherLivre("titre1", "auteur1");
			System.out.println("fournisseur : "+ resultat.nomFournisseur + " prix : " + resultat.prix );
			
		} catch (ExceptionNoLivreFound e) {
			
			System.out.println("la recherche n'a retournée aucun livre");
		}
		
	}

}
