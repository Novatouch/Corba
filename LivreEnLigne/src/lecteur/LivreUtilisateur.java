package lecteur;

import commun.Livre;

import LivreEnLigne.Fournisseur;

public class LivreUtilisateur extends Livre {

	private String nomFournisseur = null;
	private Fournisseur iorFournisseur = null;
	private String cle = null;
	private Boolean estTelecharger = false;
	
	
	
	public LivreUtilisateur(String pAuteur, String pTitre, String pNomFournisseur, Fournisseur pIorFournisseur) {
		super(pAuteur, pTitre);
		
		this.nomFournisseur = nomFournisseur;
		this.iorFournisseur = iorFournisseur;
	}
	

	public String getNomFournisseur() {
		return nomFournisseur;
	}



	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}



	public Fournisseur getIorFournisseur() {
		return iorFournisseur;
	}



	public void setIorFournisseur(Fournisseur iorFournisseur) {
		this.iorFournisseur = iorFournisseur;
	}



	public String getCle() {
		return cle;
	}



	public void setCle(String cle) {
		this.cle = cle;
	}



	public Boolean getEstTelecharger() {
		return estTelecharger;
	}



	public void setEstTelecharger(Boolean estTelecharger) {
		this.estTelecharger = estTelecharger;
	}



	public String dechiffrement(){
		
		return null;
	}
}
