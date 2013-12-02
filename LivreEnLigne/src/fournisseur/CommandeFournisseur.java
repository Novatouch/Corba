package fournisseur;

import LivreEnLigne.Lecteur;
import LivreEnLigne.LivreChiffre;

import commun.Commande;

public class CommandeFournisseur extends Commande{
	
	private LivreCatalogue livre = null;
	private Lecteur IorAchetteur = null;
	private Lecteur IorPreteur = null;

	public CommandeFournisseur(String pNomAchetteur, Lecteur pIorAchetteur, String pNomPreteur, Lecteur pIorPreteur, LivreCatalogue pLivre) {
		super(pNomAchetteur, pNomPreteur);
		
		this.IorAchetteur = pIorAchetteur;
		this.IorPreteur = pIorPreteur;
		this.livre = pLivre;
	}

	public CommandeFournisseur(String pNomAchetteur, Lecteur pIorAchetteur, LivreCatalogue pLivre) {
		super(pNomAchetteur);
		
		this.IorAchetteur = pIorAchetteur;
		this.livre = pLivre;
	}
	
	public Lecteur getIorAchetteur() {
		return IorAchetteur;
	}

	public void setIorAchetteur(Lecteur iorAchetteur) {
		IorAchetteur = iorAchetteur;
	}

	public Lecteur getIorPreteur() {
		return IorPreteur;
	}

	public void setIorPreteur(Lecteur iorPreteur) {
		IorPreteur = iorPreteur;
	}
	
	public LivreCatalogue getLivre() {
		return livre;
	}

	public void setLivre(LivreCatalogue livre) {
		this.livre = livre;
	}	
}
