package test;

import java.util.Scanner;

import lecteur.Bibliotheque;
import lecteur.ExceptionLivreIsEnCoursPret;
import lecteur.ExceptionLivreNotTelecharge;
import lecteur.ExceptionNoLivreInBibliotheque;
import lecteur.ExceptionPretEstTropOld;
import lecteur.InterfaceLivreEnLigne;
import lecteur.LecteurCorbaWorker;
import lecteur.LivreUtilisateur;
import lecteur.LivreUtilisateurPret;
import lecteur.ServantLecteur;
import LivreEnLigne.ExceptionAuthorizationFailed;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.ExceptionPretNotAllowed;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Lecteur;

import commun.Debug;

import corba.CorbaLivreEnLigne;
import fournisseur.FournisseurCorbaWorker;

public class testLecteurEmprunteur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nomLecteur = "lecteur2";

		
		Debug.afficherLog("info","testLecteur :  Lancement testLecteur");
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);
		
		Bibliotheque bibliotheque = new Bibliotheque();
		Bibliotheque bibliothequePret = new Bibliotheque();
		

		// création servant Lecteur 
		ServantLecteur servantLecteur = new ServantLecteur(nomLecteur, bibliotheque, bibliothequePret);
		
		// Déclaration servant Lecteur

		Debug.afficherLog("info","testLecteurEnprunteur : Enregistrement du servant auprès du naming service");
		corbaManager.enregistrementServant(nomLecteur, servantLecteur);
		
		// Demarrer corbaWorker
		Debug.afficherLog("info","testLecteur : Démmarage Corba Worker");
		
		Thread t1 = new Thread(new LecteurCorbaWorker(corbaManager));
		t1.start();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			Debug.afficherLog("error","testLecteurEnprunteur : Arret thread principal impossible");
		}
		
		Debug.afficherLog("info","testLecteurEnprunteur : création InterfaceLivreEnLigne");
		InterfaceLivreEnLigne interfaceLivreEnLigne = new InterfaceLivreEnLigne(corbaManager, bibliotheque, bibliothequePret, "mandataire", nomLecteur, "controleur");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Lecture du livre emprunter : (y/n)");
		
		String str = sc.nextLine();
		
		try {
			Debug.afficherLog("info","testLecteurEnprunteur : Tentative recherche livre");
			LivreUtilisateurPret livre = bibliothequePret.rechercherLivrePret("titre1", "auteur1","lecteur1");
			
			
			Debug.afficherLog("info","testLecteurEnprunteur : Tentative lecture contenu livre");
			try {
				
				String contenu;
				try {
					contenu = interfaceLivreEnLigne.LireLivre(livre);
					Debug.afficherLog("info","Lecture autorisee");
					
					Debug.afficherLog("info","testLecteur : contenu livre : " + contenu);
					
					
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Lecture du livre emprunter 2ème essai : (y/n)");
					
					String str1 = sc1.nextLine();
					
					livre = bibliothequePret.rechercherLivrePret("titre1", "auteur1","lecteur1");
					
					contenu = interfaceLivreEnLigne.LireLivre(livre);
					Debug.afficherLog("info","Lecture autorisee");
					
					Debug.afficherLog("info","testLecteur : contenu livre : " + contenu);
					
				} catch (ExceptionPretEstTropOld e) {
					Debug.afficherLog("info","testLecteur : Le pret est trop vieux bye bye");
					
				} catch (ExceptionLivreIsEnCoursPret e) {
					Debug.afficherLog("info","testLecteur : Le livre est en cours de pret");
				}

			} catch (ExceptionAuthorizationFailed e) {
				
				Debug.afficherLog("error","testLecteurEnprunteur : vous n'êtes pas autorisé à lire le livre");
			} catch (ExceptionLivreNotTelecharge e) {
				
				Debug.afficherLog("error","testLecteurEnprunteur : le livre n'est pas encore télécharger");
			}
			
		} catch (ExceptionNoLivreInBibliotheque e) {
			
			Debug.afficherLog("error","testLecteurEnprunteur : le livre n'est pas dans la biblotheque");
			
		}
	}
}