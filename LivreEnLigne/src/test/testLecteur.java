package test;

import lecteur.Bibliotheque;
import lecteur.InterfaceLivreEnLigne;
import lecteur.ServantLecteur;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Lecteur;

import commun.Debug;

import corba.CorbaLivreEnLigne;

public class testLecteur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nomServeur = "lecteur1";
		
		Debug.afficherLog("info","Lancement testLecteur");
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		Bibliotheque bibliotheque = new Bibliotheque();
		
		Debug.afficherLog("info","création InterfaceLivreEnLigne");
		
		// création servant Lecteur 
		ServantLecteur monLecteur = new ServantLecteur();
		
		// Déclaration servant Lecteur

		Debug.afficherLog("info","Enregistrement du servant auprès du naming service");
		corbaManager.enregistrementServant(nomServeur, monLecteur);
		
		Lecteur iorLecteur = corbaManager.resolveObjetLecteur(nomServeur);
		
		InterfaceLivreEnLigne interfaceLecteur = new InterfaceLivreEnLigne("mandataire", corbaManager, bibliotheque, nomServeur, iorLecteur);
		
		
		
		
		Debug.afficherLog("info","test d'une recherche aupèrs du mandataire");
		
		try {
			InfoRecherche resultat = interfaceLecteur.rechercherLivre("titre1", "auteur1");
			System.out.println("fournisseur : "+ resultat.nomFournisseur + " prix : " + resultat.prix );
			
			Debug.afficherLog("info","test d'une commande auprès du Fournisseur");
			
			try {
				resultat.iorFournisseur.commander("titre1", "auteur1", "bla", "bla", nomServeur, iorLecteur);
				
				Debug.afficherLog("info","commande réussie");
			} catch (ExceptionEchecCommande e) {
				
				Debug.afficherLog("info","commande échouée");
			}
			
		} catch (ExceptionNoLivreFound e) {
			
			System.out.println("la recherche n'a retournée aucun livre");
		}
		
	}

}
