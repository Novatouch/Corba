package controleur;

import LivreEnLigne.Lecteur;
import commun.Commande;
import commun.ExceptionLivreNotPretable;

public class CommandeControleur extends Commande{


	private String titre = null;
	private String auteur = null;
	private String fournisseur = null;
	
	public CommandeControleur(String pNomAchetteur, String pTitre, String pAuteur, String pNomFournisseur ) {
		super(pNomAchetteur);
		
		titre = pTitre ;
		auteur = pAuteur;
		fournisseur = pNomFournisseur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public void pretValide() throws ExceptionPretNotValide{
		
		long duree = System.currentTimeMillis() - this.debutPret;
		long month2 = 30 * 24 * 60 *60 * 100;
		
		if((estPrete == false) || (estPrete == true && duree > month2)){
			throw new ExceptionPretNotValide();
		}
	}
}
