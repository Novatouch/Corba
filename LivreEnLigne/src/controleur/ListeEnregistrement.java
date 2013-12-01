package controleur;

import java.util.concurrent.ConcurrentHashMap;

import commun.Debug;

import fournisseur.Telechargement;

public class ListeEnregistrement {

	private ConcurrentHashMap<String,CommandeControleur> liste;
	
    public ListeEnregistrement(){
    	liste = new ConcurrentHashMap<String,CommandeControleur>();
    }
	
    public void ajouterEnregistrement(CommandeControleur pCommande){
    	
    	String titre = pCommande.getTitre();
    	String auteur = pCommande.getAuteur();
    	String fournisseur = pCommande.getFournisseur();
    	String achetteur = pCommande.getAchetteur();
    	
    	liste.put(titre + auteur + fournisseur + achetteur, pCommande);
    }
}
