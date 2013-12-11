package fournisseur;


import java.util.Random;

import commun.Debug;

import LivreEnLigne.LivreChiffre;

public class Telechargement {

	private static final short Integer = 0;
	private CommandeFournisseur commande = null;
	private LivreChiffre livreChiffre = null;
	private Boolean aChiffre; 
	private Boolean enCoursDeChiffrement;
	private Boolean aEnvoyer;
	private Boolean miseAjour = false;


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
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		Random rand = new Random(Short.MAX_VALUE);
		return (short) rand.nextInt(Short.MAX_VALUE);
	}

	public LivreChiffre getLivreChiffre() {
		return livreChiffre;
	}

	public void setLivreChiffre(LivreChiffre livreChiffre) {
		this.livreChiffre = livreChiffre;
	}
	
	
	public Boolean getMiseAjour() {
		return miseAjour;
	}

	public void setMiseAjour(Boolean miseAjour) {
		this.miseAjour = miseAjour;
	}
	
}
