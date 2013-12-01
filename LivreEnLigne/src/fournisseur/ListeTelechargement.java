package fournisseur;

import java.util.concurrent.ConcurrentHashMap;

public class ListeTelechargement {

	private ConcurrentHashMap<String,Telechargement> liste;
	
    public ListeTelechargement(){
    	liste = new ConcurrentHashMap<String,Telechargement>();
    }
    
    public void ajouterTelechargement(Telechargement pTelechargement){
    	
    	
    	String titre = pTelechargement.getCommandeFournisseur().getLivre().getTitre();
    	String auteur = pTelechargement.getCommandeFournisseur().getLivre().getAuteur();
    	String utilisateur = pTelechargement.getCommandeFournisseur().getAchetteur();
    	
    	liste.put(titre + auteur + utilisateur , pTelechargement);
    }
    
    public void supprimerTelechargement(Telechargement pTelechargement){
    
    	String titre = pTelechargement.getCommandeFournisseur().getLivre().getTitre();
    	String auteur = pTelechargement.getCommandeFournisseur().getLivre().getAuteur();
    	String utilisateur = pTelechargement.getCommandeFournisseur().getAchetteur();
    	
    	liste.remove(titre + auteur + utilisateur);
    }
}