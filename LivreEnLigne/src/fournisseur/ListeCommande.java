 package fournisseur;

import java.util.concurrent.ConcurrentHashMap;

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
    
    public void flush(){
    	liste.clear();
    }
    
}
