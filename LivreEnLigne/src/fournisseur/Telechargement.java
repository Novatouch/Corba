package fournisseur;

import LivreEnLigne.LivreChiffre;

public class Telechargement {

	private CommandeFournisseur commande = null;
	private LivreChiffre livreChiffre = null;
	private Boolean aChiffre; 
	private Boolean enCoursDeChiffrement;
	private Boolean aEnvoyer;
	
	public Telechargement(CommandeFournisseur pCommande){
		
		commande = pCommande;
		aChiffre = true;
		enCoursDeChiffrement = false;
		aEnvoyer = false;
	}

	public Boolean getaChiffre() {
		return aChiffre;
	}

	public void setaChiffre(Boolean aChiffre) {
		this.aChiffre = aChiffre;
	}

	synchronized public Boolean getEnCoursDeChiffrement() {
		return enCoursDeChiffrement;
	}

	synchronized public void setEnCoursDeChiffrement(Boolean enCoursDeChiffrement) {
		this.enCoursDeChiffrement = enCoursDeChiffrement;
	}

	public CommandeFournisseur getCommandeFournisseur() {
		return commande;
	}
	
	synchronized public Boolean getaEnvoyer() {
		return aEnvoyer;
	}

	synchronized public void setaEnvoyer(Boolean aEnvoyer) {
		this.aEnvoyer = aEnvoyer;
	}

	
	public void chiffrementContenuLivre() {
		
		// génération d'une clé de chiffreme
		short cle = genererCle();
		
		// chiffrer contenu livre
		String contenuChiffre = chiffrementContenu(commande.getLivre().getContenu(), cle);
		
		// enregistrement du resultat livreChiffre
		livreChiffre = new LivreChiffre (contenuChiffre, cle);
	}
	
	private String chiffrementContenu(String pContenuAChiffrer, short pCle){
		
	    String chaineCryptee = "";
	    for(int i = 0; i < pContenuAChiffrer.length(); i++)
	    {
	        chaineCryptee += (char)((int)pContenuAChiffrer.charAt(i) ^ pCle);
	    }
	    
	    return chaineCryptee;
	}
	
	private short genererCle(){
       
		return (short) Math.floor(Math.random());
	}
	
}
