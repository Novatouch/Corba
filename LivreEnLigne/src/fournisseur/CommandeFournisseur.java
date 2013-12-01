package fournisseur;

import commun.Commande;
import commun.Livre;

import LivreEnLigne.Lecteur;

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
	
	public LivreCatalogue getLivre() {
		return livre;
	}

	public void setLivre(LivreCatalogue livre) {
		this.livre = livre;
	}

	
}
