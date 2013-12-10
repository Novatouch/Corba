package fournisseur;

import LivreEnLigne.Lecteur;
import LivreEnLigne.LivreChiffre;

import commun.Commande;

public class CommandeFournisseur extends Commande{
	
	private LivreCatalogue livre = null;
	private Lecteur IorAchetteur = null;
	private Lecteur IorEmprunteur = null;

	public CommandeFournisseur(String pNomAchetteur, Lecteur pIorAchetteur, String pNomEmprunteur, Lecteur pIorEmprunteur, LivreCatalogue pLivre) {
		super(pNomAchetteur, pNomEmprunteur);
		
		this.IorAchetteur = pIorAchetteur;
		this.IorEmprunteur = pIorEmprunteur;
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

	public Lecteur getIorEmprunteur() {
		return IorEmprunteur;
	}

	public void setIorEmprunteur(Lecteur iorPreteur) {
		IorEmprunteur = iorPreteur;
	}
	
	public LivreCatalogue getLivre() {
		return livre;
	}

	public void setLivre(LivreCatalogue livre) {
		this.livre = livre;
	}	
}
