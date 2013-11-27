package test;

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
		Mandataire mandataire = corbaManager.resolveObjetMandataire("mandataire");
		
		try {
			InfoRecherche resultat = mandataire.rechercherLivre("bla", "bla");
			System.out.println("fournisseur : "+ resultat.nomFournisseur + " Iorfournisseur : " + resultat.iorFournisseur + " prix : " + resultat.prix );
			
		} catch (ExceptionNoLivreFound e) {
			
			System.out.println("la recherche n'a retournée aucun livre");
		}
		
	}

}
