package test;

import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class testFournisseur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		// resolution mandataire
		Debug.afficherLog("info","Résolution du Fournisseur auprès du serveur de nommage");
		Fournisseur fournisseur = corbaManager.resolveObjetFournisseur("fournisseur2");
		
		Debug.afficherLog("info","test d'une recherche auprès du fournisseur");
		
		try {
			
			float resultat = fournisseur.rechercherLivre("titre1", "auteur1");
			
			System.out.println("Prix retourné par le fournisseur : " + resultat + "€");
			
			//System.out.println("fournisseur : "+ resultat.nomFournisseur + " Iorfournisseur : " + resultat.iorFournisseur + " prix : " + resultat.prix );
			
		} catch (ExceptionNoLivreFound e) {
			
			System.out.println("la recherche n'a retourné aucun livre");
		}
		
	}

}
