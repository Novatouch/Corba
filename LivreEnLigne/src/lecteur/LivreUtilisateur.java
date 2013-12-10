package lecteur;


import LivreEnLigne.Fournisseur;
import LivreEnLigne.Lecteur;

public class LivreUtilisateur extends LivreUtilisateurVirtual {



	private String nomEmprunteur = null;
	private Lecteur iorEmprunteur = null;
	protected Boolean estPrete = false;
	
	
	public LivreUtilisateur(String pAuteur, String pTitre,
			String pNomFournisseur, Fournisseur pIorFournisseur) {
		super(pAuteur, pTitre, pNomFournisseur, pIorFournisseur);

	}
	
	
	public Boolean getEstPrete() {
		return estPrete;
	}

	public void setEstPrete(Boolean estPrete) {
		this.estPrete = estPrete;
	}

	public void lecturePossible() throws  ExceptionLivreIsEnCoursPret, ExceptionLivreNotTelecharge{
		if(this.estTelecharger == true){
			if(estPrete == true){
				throw new ExceptionLivreIsEnCoursPret();
			}
		}
		else {
			throw new ExceptionLivreNotTelecharge();
		}
	}


	public String getNomEmprunteur() {
		return nomEmprunteur;
	}


	public void setNomEmprunteur(String nomEmprunteur) {
		this.nomEmprunteur = nomEmprunteur;
	}


	public Lecteur getIorEmprunteur() {
		return iorEmprunteur;
	}


	public void setIorEmprunteur(Lecteur iorEmprunteur) {
		this.iorEmprunteur = iorEmprunteur;
	}
	
}
