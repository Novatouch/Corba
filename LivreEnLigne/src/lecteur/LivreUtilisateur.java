package lecteur;

import commun.Livre;

import LivreEnLigne.Fournisseur;

public class LivreUtilisateur extends Livre {

	private String nomFournisseur = null;
	private Fournisseur iorFournisseur = null;
	private short cle;
	private Boolean estTelecharger;
	private Boolean lectureAutorisee;
	
	public LivreUtilisateur(String pAuteur, String pTitre, String pNomFournisseur, Fournisseur pIorFournisseur) {
		super(pAuteur, pTitre);
		estTelecharger = false;
		lectureAutorisee = false;
		this.nomFournisseur = nomFournisseur;
		this.iorFournisseur = iorFournisseur;
	}
	
	
	public Boolean getLectureAutorisee() {
		return lectureAutorisee;
	}


	public void setLectureAutorisee(Boolean lectureAutorisee) {
		this.lectureAutorisee = lectureAutorisee;
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



	public short getCle() {
		return cle;
	}



	public void setCle(short cle2) {
		this.cle = cle2;
	}



	public Boolean getEstTelecharger() {
		return estTelecharger;
	}



	public void setEstTelecharger(Boolean estTelecharger) {
		this.estTelecharger = estTelecharger;
	}



	public String dechiffrementLivre(){
		
		String chaineDechiffree = "";
	    for(int i = 0; i < this.contenu.length(); i++)
	    {
	    	chaineDechiffree += (char)((int)this.contenu.charAt(i) ^ cle);
	    }
	    
	    return chaineDechiffree;
	}
	

}
