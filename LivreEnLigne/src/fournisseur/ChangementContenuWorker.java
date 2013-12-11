package fournisseur;

import java.util.ArrayList;
import java.util.Scanner;

import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.Lecteur;

import commun.Debug;

public class ChangementContenuWorker implements Runnable{


	private ListeTelechargement listeTelechargementPret;
	private ListeTelechargement listeTelechargement;
	private String nomServeur = null;
	private Catalogue catalogue = null;
	private ListeCommande listeCommande = null;
	
	public ChangementContenuWorker( String pNomServeur, ListeTelechargement pListeTelechargementPret, 
			ListeTelechargement pListeTelechargement, Catalogue pCatalogue, ListeCommande pListeCommande ){
		
		nomServeur = pNomServeur;
		listeTelechargementPret = pListeTelechargementPret;
		listeTelechargement = pListeTelechargement;
		catalogue = pCatalogue;
		listeCommande = pListeCommande;
	}

	private void chiffrementLivre(Telechargement pObjetTelechargement){

	}
	
	private void afficheListeLivre(ArrayList<String> pList){
		
		System.out.println("Liste des titres de livres présents dans le catalogue.\n");
		
		for (int i = 0; i < pList.size(); i++) {

			String titre = pList.get(i);
			System.out.println(" " + i + "	- " + titre);
		}
		
		System.out.println("Entrer le numéro du livre à modifier (toute autre frappe pour recharger la liste)");
	}
	
	private Integer recupererReponseUtilisateur(Integer pTailleListe) throws ExceptionSaisieDeMerde{
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		try {
            Integer nombre = Integer.parseInt(str);
            
            if (nombre < 0 || nombre < pTailleListe){
            	
            	return nombre;
            }
            else {
            	Debug.afficherLog("info","changementContenuWorker >  recupererReponseUtilisateur: nombre trop grand");
            	throw new ExceptionSaisieDeMerde();
            }
            
        } catch (NumberFormatException e) {
            
        	Debug.afficherLog("info","changementContenuWorker >  recupererReponseUtilisateur: erreur de formattage");
        	throw new ExceptionSaisieDeMerde();
        }
	}
	
	private String saisieNouveauContenu() {
		
		System.out.println("Entrer le nouveau contenu du livre :");
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		return str;
	}
	
	private void mettreAjourContenuLivre(String pIndice, String pNouveauContenu) throws ExceptionNoLivreFound {
		
		// recuperer livre
		LivreCatalogue livre = catalogue.getLivre(pIndice);
		
		// mettre a jour contenu
		livre.setContenu(pNouveauContenu);
		
		// rechercher les commande contenant le livre
		ArrayList<CommandeFournisseur> listCommande = listeCommande.getListeCommandeLivre(livre.getTitre(), livre.getAuteur());
		
		// parcourir chaque commande pour avertir les clients
		for (int i = 0; i < listCommande.size(); i++) {

			CommandeFournisseur commande = listCommande.get(i);
			
			Telechargement nouveauTelechargement = new Telechargement(commande);
			nouveauTelechargement.setMiseAjour(true);
			
			// ajouter la commande à la liste des telechargement
			if(commande.getEstPrete() == true){
				Telechargement nouveauTelechargementPret = new Telechargement(commande);
				nouveauTelechargementPret.setMiseAjour(true);
				
				Debug.afficherLog("info","changementContenuWorker >  mettreAjourContenuLivre: ajout commande liste de telechargementPret");
				listeTelechargementPret.ajouterTelechargement(nouveauTelechargementPret);
			}
			
			Debug.afficherLog("info","changementContenuWorker >  mettreAjourContenuLivre: ajout commande liste de telechargement");
			listeTelechargement.ajouterTelechargement(nouveauTelechargement);
		}
	}
	
	@Override
	public void run() {
		
		while(true){
			
			// recuperer liste livre catalogue
			ArrayList<String> list = catalogue.getkeys();
			
			// afficher la liste
			afficheListeLivre(list);
			
			try {
				
				// recuperer la réponse de l'utilisateur
				Integer indice = recupererReponseUtilisateur(list.size());
				
				// saisir le nouveau contenu du livre
				String nouveauContenu = saisieNouveauContenu();
				
				// mettre a jour le contenu du livre
				String livreKey = list.get(indice);
				
				try {
					mettreAjourContenuLivre(livreKey, nouveauContenu);
				} catch (ExceptionNoLivreFound e) {
					
					System.out.println("Mise ajour du contenu échouée livre introuvable dans le catalogue !");
				}
				
			} catch (ExceptionSaisieDeMerde e) {
				
				System.out.println("Rafraichissement de la liste");
			}
		}
	}
}
