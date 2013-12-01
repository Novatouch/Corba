package controleur;

import LivreEnLigne.Lecteur;
import commun.Commande;

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
}
