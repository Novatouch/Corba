package lecteur;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import LivreEnLigne.ExceptionAuthorizationFailed;
import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.ExceptionPretNotAllowed;
import LivreEnLigne.ExceptionPretNotDeleted;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Lecteur;

import commun.Debug;

import corba.CorbaLivreEnLigne;
import fournisseur.ExceptionSaisieDeMerde;

public class LecteurMain {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Saisie du nom d utilisateur
		System.out.println("\nVotre nom?");
		String nomLecteur = sc.nextLine();

		Debug.afficherLog("info","testLecteur :  Lancement testLecteur");
		CorbaLivreEnLigne corbaManager = new CorbaLivreEnLigne(args);

		Bibliotheque bibliotheque = new Bibliotheque();
		
		Debug.afficherLog("info","testLecteur : crÃ©ation InterfaceLivreEnLigne");

		// crÃ©ation servant Lecteur 
		ServantLecteur servantLecteur = new ServantLecteur(nomLecteur, bibliotheque);
		// DÃ©claration servant Lecteur

		Debug.afficherLog("info","testLecteur : Enregistrement du servant auprÃ¨s du naming service");
		corbaManager.enregistrementServant(nomLecteur, servantLecteur);

		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			Debug.afficherLog("error","testLecteur : Arret thread principal impossible");
		}

		Lecteur iorLecteur = corbaManager.resolveObjetLecteur(nomLecteur);

		InterfaceLivreEnLigne interfaceLivreEnLigne = new InterfaceLivreEnLigne(corbaManager, bibliotheque, "mandataire", nomLecteur, "controleur");

		// Demarrer corbaWorker
		Debug.afficherLog("info","testLecteur : DÃ©mmarage Corba Worker");

		Thread t1 = new Thread(new LecteurCorbaWorker(corbaManager));
		t1.start();

		System.out.println("Bienvenue dans votre liseuse de livre !");
		String value;


		while (true) {
			makeChoise(interfaceLivreEnLigne, bibliotheque);
		}

	}

	private static void makeChoise (InterfaceLivreEnLigne interfaceLivreEnLigne, Bibliotheque bibliotheque ) {
		Scanner sc = new Scanner(System.in);
		
		String value;

		System.out.println("\nQue souhaitez vous faire ?\n1 - Accéder à ma bibliothèque\n2 - Acheter un livre\n3 - Prêter un livre\n4 - Annuler un prêt");
		value = sc.nextLine();
		switch (value) {
		case "1":
			System.out.println("lectureLivre(bibliotheque)");
			lectureLivre (interfaceLivreEnLigne, bibliotheque);
			break;
		case "2":
			System.out.println("achatLivre(interfaceLivreEnLigne)");
			achatLivre(interfaceLivreEnLigne);
			break;
		case "3":
			System.out.println("pretLivre()");
			pretLivre(interfaceLivreEnLigne);
			break;
		case "4":
			System.out.println("annulerPret()");
			annulerPret(interfaceLivreEnLigne);
			break;
		default:
			System.out.println("Merci de choisir une option proposée dans le menu");
			break;
		}

	}

	private static void lectureLivre (InterfaceLivreEnLigne interfaceLivreEnLigne, Bibliotheque bibliotheque) {
		Scanner sc = new Scanner(System.in);

		String value;
		int indice;

		//récuperation des listes de livres
		ArrayList<LivreUtilisateur> livreAchete = interfaceLivreEnLigne.getLivreAchette();
		ArrayList<LivreUtilisateurPret> livreEmprunte = interfaceLivreEnLigne.getLivreEmprunte();

		//creation des iterators
		java.util.Iterator<LivreUtilisateur> itachete = livreAchete.iterator();
		java.util.Iterator<LivreUtilisateurPret> itemprunte = livreEmprunte.iterator();


		int i = 1;

		System.out.println("\nListe des livres que vous possedez : \n");
		while (itachete.hasNext()) {

			LivreUtilisateur li = itachete.next();
			System.out.println(i + "]\t" + li.getTitre() + "\t\t\t de : " + li.getAuteur());
			i++;

		}

		if (i==1){
			System.out.println("Vous n'avez aucun livres");
		}

		System.out.println("\nListe des livres que l'on vous a preté : \n");

		int j = i;
		while (itemprunte.hasNext()) {

			LivreUtilisateurPret li = itemprunte.next();
			System.out.println(j + "]\t" + li.getTitre() + "\t\t\t de : " + li.getAuteur());
			j++;

		}

		if (j==1){
			System.out.println("Personne ne vous a prété de livre");
		}

		if (j>1){

			//Saisie de la recherche du livre
			System.out.println("\nChoisir un livre : ");

			value = sc.nextLine();

			try {
				Integer nombre = Integer.parseInt(value);

				if (nombre > 0 || nombre < j){

					LivreUtilisateurVirtual livre;
					if (nombre >= i){
						indice =  nombre - i;
						livre = livreEmprunte.get(indice);
					} else {
						indice = nombre - 1;
						livre = livreAchete.get(indice);
					}


					try {
						try {
							System.out.println(interfaceLivreEnLigne.LireLivre(livre));
						} catch (ExceptionAuthorizationFailed e) {
							System.out.println("La verification aupres du controleur a echoue");
						} catch (ExceptionPretEstTropOld e) {
							System.out.println("Le pret a expriré");
						} catch (ExceptionLivreIsEnCoursPret e) {
							System.out.println("Le livre est en cour de pret");	
						}
					} catch (ExceptionLivreNotTelecharge e) {
						System.out.println("Le livre n'a pas encore Ã©tÃ© tÃ©lÃ©chargÃ© auprÃ¨s du fournisseur");
					}

				}
				else {
					System.out.println("Le livre que vous avez choisir n'est pas dans la liste");
				}

			} catch (NumberFormatException e) {

				System.out.println("Saisie invalide");
			}

		}

	}


	private static void achatLivre (InterfaceLivreEnLigne interfaceLivreEnLigne) {
		
		Scanner sc = new Scanner(System.in);

		InfoRecherche resultat;
		String auteur;
		String titre;
		String value;

		try {

			//Saisie de la recherche du livre
			System.out.println("\nTitre du livre ?");
			titre = sc.nextLine();

			System.out.println("\nAuteur du livre ?");
			auteur = sc.nextLine();

			//Recherche sur le mandataire
			resultat = interfaceLivreEnLigne.rechercherLivre(titre, auteur);

			System.out.println("\nRecherche du livre "+ titre +" ecrit par "+ auteur +".");

			//Affichage de la réponse du mandataire
			System.out.println("fournisseur : " + resultat.nomFournisseur + " prix : " + resultat.prix );


			//Demande d'achat 
			System.out.println("Voulez vous acheter le livre ? ([Y]/n)");
			value = sc.nextLine();

			if (value == "n" || value == "N") {
				return;
			} else {
				commande(titre , auteur, resultat, interfaceLivreEnLigne);
			}

		} catch (ExceptionNoLivreFound e) {

			System.out.println("le mandataire n'a retournÃ© aucun rÃ©sultat");
		}


	}

	private static void commande( String ptitre, String pauteur, InfoRecherche resultat, InterfaceLivreEnLigne interfaceLivreEnLigne) {
		try {
			Scanner sc = new Scanner(System.in);

			String compte;
			String code;

			//Saisie de la recherche du livre
			System.out.println("\n Saisir votre numéro de compte :");
			compte = sc.nextLine();

			System.out.println("\n Saisir votre code :");
			code = sc.nextLine();

			// commande livre 
			interfaceLivreEnLigne.commander(ptitre , pauteur, resultat.iorFournisseur, resultat.nomFournisseur,compte, code);

			Debug.afficherLog("info","testLecteur :  commande reussie");

		} catch (ExceptionEchecCommande e) {

			System.out.println("commande auprÃ¨s du Fournisseur echouÃ©e");
		}	
	}


	private static void pretLivre (InterfaceLivreEnLigne interfaceLivreEnLigne) {
		Scanner sc = new Scanner(System.in);
		//récuperation des listes de livres
		ArrayList<LivreUtilisateur> livreAchete = interfaceLivreEnLigne.getLivreAchette();

		//creation des iterators
		java.util.Iterator<LivreUtilisateur> itachete = livreAchete.iterator();


		int i = 1;

		System.out.println("\nListe des livres que vous possedez : \n");
		while (itachete.hasNext()) {

			LivreUtilisateur li = itachete.next();
			System.out.println(i + "]\t" + li.getTitre() + "\t\t\t de : " + li.getAuteur());
			i++;
		}
		
		System.out.println("\nChoisir le livre que vous voulez preter : ");

		String value = sc.nextLine();

		try {
			Integer nombre = Integer.parseInt(value);

			if (nombre > 0 || nombre < i){

				System.out.println("\nA qui voulez vous preter ce livre : ");
				String utilisateur = sc.nextLine();
				
				try {
					interfaceLivreEnLigne.preterLivre(livreAchete.get(nombre-1), utilisateur);
				} catch (ExceptionPretNotAllowed e) {
					System.out.println("Le pret a echoue");
				}
				
			}
			else {
				System.out.println("Le livre que vous avez choisir n'est pas dans la liste");
			}

		} catch (NumberFormatException e) {

			System.out.println("Saisie invalide");
		}


	}

	private static void annulerPret (InterfaceLivreEnLigne interfaceLivreEnLigne) {
		Scanner sc = new Scanner(System.in);
		//récuperation des listes de livres
		ArrayList<LivreUtilisateur> livreprete = interfaceLivreEnLigne.getLivrePrete();

		//creation des iterators
		java.util.Iterator<LivreUtilisateur> itachete = livreprete.iterator();


		int i = 1;

		System.out.println("\nListe des livres que vous possedez : \n");
		while (itachete.hasNext()) {

			LivreUtilisateur li = itachete.next();
			System.out.println(i + "]\t" + li.getTitre() + "\t\t\t de : " + li.getAuteur());
			i++;
		}
		
		System.out.println("\nChoisir le livre que vous voulez récuperer : ");

		String value = sc.nextLine();

		try {
			Integer nombre = Integer.parseInt(value);

			if (nombre > 0 || nombre < i){
				
				try {
					interfaceLivreEnLigne.annulerPreterLivre(livreprete.get(nombre-1));
				} catch (ExceptionPretNotDeleted e) {
					System.out.println("La supression du pret a échoué");
				}
				
			}
			else {
				System.out.println("Le livre que vous avez choisir n'est pas dans la liste");
			}

		} catch (NumberFormatException e) {

			System.out.println("Saisie invalide");
		}

	}

}