package lecteur;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import commun.Debug;
import fournisseur.CommandeFournisseur;

import LivreEnLigne.ExceptionNoLivreFound;


public class Bibliotheque {

	private ConcurrentHashMap<String,LivreUtilisateur> listeLivre = null;
	private ConcurrentHashMap<String,LivreUtilisateurPret> listeLivrePret = null;
	
	public Bibliotheque(){
		listeLivre = new ConcurrentHashMap<String,LivreUtilisateur>();
		listeLivrePret = new ConcurrentHashMap<String,LivreUtilisateurPret>();
	}
	
	public void ajouterLivre(LivreUtilisateur pLivre){
		listeLivre.put(pLivre.getTitre() + pLivre.getAuteur() + pLivre.getNomFournisseur(), pLivre);
		Debug.afficherLog("info","Bibliotheque : ajout d'un livre");
	}
	
	public void ajouterLivrePret(LivreUtilisateurPret pLivre){
		listeLivrePret.put(pLivre.getTitre() + pLivre.getAuteur() + pLivre.getNomProprietaire(), pLivre);
		Debug.afficherLog("info","Bibliotheque : ajout d'un livrePret");
	}
	

	public ConcurrentHashMap<String, LivreUtilisateur> getBibliotheque() {
		return listeLivre;
	}
	
	public LivreUtilisateur rechercherLivre(String pTitre, String pAuteur, String pNomFournisseur) throws ExceptionNoLivreInBibliotheque{
		
		if (listeLivre.containsKey(pTitre + pAuteur + pNomFournisseur) == false){
			throw new ExceptionNoLivreInBibliotheque();
		}
		return listeLivre.get(pTitre + pAuteur + pNomFournisseur);
	}
	
	public LivreUtilisateurPret rechercherLivrePret(String pTitre, String pAuteur, String pNomProprietaire) throws ExceptionNoLivreInBibliotheque{
		
		if (listeLivrePret.containsKey(pTitre + pAuteur + pNomProprietaire) == false){
			throw new ExceptionNoLivreInBibliotheque();
		}
		return listeLivrePret.get(pTitre + pAuteur + pNomProprietaire);
	}
	
	public void supprimerPret(String pTitre, String pAuteur, String pUtilisateurProprietaire) throws ExceptionNoLivreFound{
		if (listeLivrePret.containsKey(pTitre + pAuteur + pUtilisateurProprietaire) == true){
		listeLivrePret.remove(pTitre + pAuteur + pUtilisateurProprietaire);
		} else {
			throw new ExceptionNoLivreFound();
		}
	}
	
	public ArrayList<LivreUtilisateur> getLivreAchette(){
    	ArrayList<LivreUtilisateur> liste = new ArrayList<LivreUtilisateur>();
    	
    	// parcours de la liste des commandes
    	java.util.Iterator<String> myVeryOwnIterator = listeLivre.keySet().iterator();
    	while(myVeryOwnIterator.hasNext()) {
    	    String key=(String)myVeryOwnIterator.next();
    	    
    	    // Recup commande
    	    LivreUtilisateur livre = listeLivre.get(key);
    	    
    	    // test titre et auteur
    	    liste.add(livre);
    	}
    	
		return liste;
	}
	
	public ArrayList<LivreUtilisateurPret> getLivreEmprunte(){
		
		ArrayList<LivreUtilisateurPret> liste = new ArrayList<LivreUtilisateurPret>();
    	
    	// parcours de la liste des commandes
    	java.util.Iterator<String> myVeryOwnIterator = listeLivrePret.keySet().iterator();
    	while(myVeryOwnIterator.hasNext()) {
    	    String key=(String)myVeryOwnIterator.next();
    	    
    	    // Recup commande
    	    LivreUtilisateurPret livre = listeLivrePret.get(key);
    	    
    	    // test titre et auteur
    	    liste.add(livre);
    	}
    	
		return liste;
	}
	
}
