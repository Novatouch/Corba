package lecteur;

import commun.Livre;

import LivreEnLigne.Fournisseur;

public class LivreUtilisateurVirtual extends Livre {

	private String nomFournisseur = null;
	private Fournisseur iorFournisseur = null;
	protected short cle;
	protected Boolean estTelecharger;
	protected Boolean lectureAutorisee;


	public LivreUtilisateurVirtual(String pAuteur, String pTitre, String pNomFournisseur, Fournisseur pIorFournisseur) {
		super(pAuteur, pTitre);
		estTelecharger = false;
		lectureAutorisee = false;
		this.nomFournisseur = pNomFournisseur;
		this.iorFournisseur = pIorFournisseur;
	}
	
	public LivreUtilisateurVirtual(String pAuteur, String pTitre, String pContenu, String pNomFournisseur, Fournisseur pIorFournisseur) {
		super(pAuteur, pTitre, pContenu);
		estTelecharger = false;
		lectureAutorisee = false;
		this.nomFournisseur = pNomFournisseur;
		this.iorFournisseur = pIorFournisseur;
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
	
	public  void lecturePossible() throws ExceptionPretEstTropOld, ExceptionLivreNotTelecharge, ExceptionLivreIsEnCoursPret {
	}
}
