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
    
    public void supprimerEnregistrement(String pTitre, String pAuteur, String pNomFournisseur, 
    		String pNomAchetteur) throws ExceptionEnregistrementNotFound{
    	
    	// verifier que l'enregistrement est présent en base avant suppression
    	this.verifierExistenceEnregistrement(pTitre, pAuteur, pNomFournisseur, pNomAchetteur);
    	liste.remove(pTitre + pAuteur + pNomFournisseur + pNomAchetteur);
    }
    
    public void verifierExistenceEnregistrement(String pTitre, String pAuteur, String pNomFournisseur, 
    		String pNomAchetteur) throws ExceptionEnregistrementNotFound {
    	
    	if( liste.containsKey(pTitre + pAuteur + pNomFournisseur + pNomAchetteur) == false){
    		throw new ExceptionEnregistrementNotFound();
    	}
    }
    
    public CommandeControleur rechercherEnregistrement(String pTitre, String pAuteur, String pNomFournisseur, 
    		String pNomAchetteur) throws ExceptionEnregistrementNotFound {
    	
    	if( liste.containsKey(pTitre + pAuteur + pNomFournisseur + pNomAchetteur) == false){
    		throw new ExceptionEnregistrementNotFound();
    	}
    	
    	return liste.get(pTitre + pAuteur + pNomFournisseur + pNomAchetteur);
    }
    
    public void flush(){
    	liste.clear();
    }
}
