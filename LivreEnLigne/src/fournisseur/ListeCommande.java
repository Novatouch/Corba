 package fournisseur;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import lecteur.ExceptionNoLivreInBibliotheque;

public class ListeCommande {

	private ConcurrentHashMap<String,CommandeFournisseur> liste;
	
    public ListeCommande(){
    	liste = new ConcurrentHashMap<String,CommandeFournisseur>();
    }
    
    public void ajouterCommande(CommandeFournisseur pCommande){
    	
    	
    	String titre = pCommande.getLivre().getTitre();
    	String auteur = pCommande.getLivre().getAuteur();
    	String utilisateur = pCommande.getAchetteur();
    	
    	liste.put(titre + auteur + utilisateur, pCommande);
    }
    
    public CommandeFournisseur rechercherCommande(String pTitre, String pAuteur, String pAchetteur) throws ExceptionNoCommandeInList{
    	
    	if (liste.containsKey(pTitre + pAuteur + pAchetteur) == false){
    		throw new ExceptionNoCommandeInList();
    	}
    	return liste.get(pTitre + pAuteur + pAchetteur);
    }
    
    public ArrayList<CommandeFournisseur> getListeCommandeLivre(String pTitre, String pAuteur){
    	
    	
    	ArrayList<CommandeFournisseur> listeCommande = new ArrayList<CommandeFournisseur>();
    	
    	// parcour de la liste des commandes
    	
    	
    	java.util.Iterator<String> myVeryOwnIterator = liste.keySet().iterator();
    	while(myVeryOwnIterator.hasNext()) {
    	    String key=(String)myVeryOwnIterator.next();
    	    
    	    // Recup commande
    	    
    	    CommandeFournisseur commande = liste.get(key);
    	    
    	    String titre = commande.getLivre().getTitre();
    	    String auteur = commande.getLivre().getAuteur();
    	    
    	    // test titre et auteur
    	    if(titre.equals(pTitre) && auteur.equals(pAuteur)){
    	    	listeCommande.add(commande);
    	    }
    	}
    	
		return listeCommande;
    }
    
    public void flush(){
    	liste.clear();
    }
    
}
