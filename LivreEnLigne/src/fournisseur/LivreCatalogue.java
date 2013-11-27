package fournisseur;

import commun.Livre;

public class LivreCatalogue extends Livre{
	
	private Float prix = null;
	private Boolean enVente = null;
	
	public LivreCatalogue(String pAuteur, String pTitre, String pContenu, Float pPrix, Boolean pEnVente) {
		
		super(pAuteur,pTitre, pContenu);
		this.prix = pPrix;
		this.enVente = pEnVente;
	}

	public synchronized Float getPrix() {
		return prix;
	}

	public synchronized void setPrix(Float pPrix) {
		this.prix = pPrix;
	}

	public synchronized Boolean getEnVente() {
		return enVente;
	}

	public synchronized void setEnVente(Boolean pEnVente) {
		this.enVente = pEnVente;
	}
}
