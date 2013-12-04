package test;

import java.util.Scanner;

import lecteur.Bibliotheque;
import lecteur.ExceptionLivreNotTelecharge;
import lecteur.ExceptionNoLivreInBibliotheque;
import lecteur.InterfaceLivreEnLigne;
import lecteur.LecteurCorbaWorker;
import lecteur.LivreUtilisateur;
import lecteur.ServantLecteur;
import LivreEnLigne.ExceptionAuthorizationFailed;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Lecteur;

import commun.Debug;

import corba.CorbaLivreEnLigne;
import fournisseur.FournisseurCorbaWorker;

public class testLecteur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nomLecteur = "lecteur1";
		
		Debug.afficherLog("info","testLecteur :  Lancement testLecteur");
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		Bibliotheque bibliotheque = new Bibliotheque();
		
		Debug.afficherLog("info","testLecteur : création InterfaceLivreEnLigne");
		
		// création servant Lecteur 
		ServantLecteur servantLecteur = new ServantLecteur(nomLecteur, bibliotheque);
		
		// Déclaration servant Lecteur

		Debug.afficherLog("info","testLecteur : Enregistrement du servant auprès du naming service");
		corbaManager.enregistrementServant(nomLecteur, servantLecteur);
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			Debug.afficherLog("error","testLecteur : Arret thread principal impossible");
		}
		
		Lecteur iorLecteur = corbaManager.resolveObjetLecteur(nomLecteur);
		
		InterfaceLivreEnLigne interfaceLivreEnLigne = new InterfaceLivreEnLigne(corbaManager, bibliotheque, "mandataire", nomLecteur, "controleur");
		
		// Demarrer corbaWorker
		Debug.afficherLog("info","testLecteur : Démmarage Corba Worker");
		
		Thread t1 = new Thread(new LecteurCorbaWorker(corbaManager));
		t1.start();
		
		Debug.afficherLog("info","testLecteur :  test d'une recherche auprès du mandataire");
		
		
		InfoRecherche resultat;
		try {
			resultat = interfaceLivreEnLigne.rechercherLivre("titre1", "auteur1");
			
			System.out.println("fournisseur : " + resultat.nomFournisseur + " prix : " + resultat.prix );
			
			try {
				Debug.afficherLog("info","testLecteur :  test d'une commande auprès du Fournisseur");
				
				interfaceLivreEnLigne.commander("titre1", "auteur1", resultat.iorFournisseur, resultat.nomFournisseur,"bla", "bla");
				
				Debug.afficherLog("info","testLecteur :  commande reussie");
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Veuillez saisir un mot :");
				String str = sc.nextLine();
				
				
				try {
					LivreUtilisateur livre;
					
					Debug.afficherLog("info","testLecteur :  tentative de lecture du livre");
					livre = bibliotheque.rechercherLivre("titre1", "auteur1", "fournisseur1");
					
					String contenu;
					try {
						contenu = interfaceLivreEnLigne.LireLivre(livre);
						
						Debug.afficherLog("info","Lecture autorisee");
						
						System.out.println("contenu livre : " + contenu);
						
						
					} catch (ExceptionAuthorizationFailed e) {
						
						Debug.afficherLog("info","testLecteur :  le controleur vous a refusé l'accès au livre");
					} catch (ExceptionLivreNotTelecharge e) {
						
						Debug.afficherLog("info","testLecteur :  Le livre n'a pas encore été téléchargé auprès du fournisseur");
					}
					
				} catch (ExceptionNoLivreInBibliotheque e) {
					Debug.afficherLog("info","testLecteur :  livre introuvable dans la biliotheque");
				}
			
			} catch (ExceptionEchecCommande e) {
				
				Debug.afficherLog("info","testLecteur :  commande auprès du Fournisseur echouée");
			}
			
		} catch (ExceptionNoLivreFound e) {
			
			Debug.afficherLog("info","testLecteur : le mandataire n'a retourné aucun résultat");
			
		}
	}
}