 package fournisseur;

import java.util.concurrent.ConcurrentHashMap;

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
}
