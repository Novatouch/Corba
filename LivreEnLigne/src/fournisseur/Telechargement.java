package fournisseur;

public class Telechargement {

	private CommandeFournisseur commande = null;
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

	public Boolean getEnCoursDeChiffrement() {
		return enCoursDeChiffrement;
	}

	public void setEnCoursDeChiffrement(Boolean enCoursDeChiffrement) {
		this.enCoursDeChiffrement = enCoursDeChiffrement;
	}

	public CommandeFournisseur getCommandeFournisseur() {
		return commande;
	}
	
	public Boolean getaEnvoyer() {
		return aEnvoyer;
	}

	public void setaEnvoyer(Boolean aEnvoyer) {
		this.aEnvoyer = aEnvoyer;
	}
	
}
