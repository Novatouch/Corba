package mandataire;

import LivreEnLigne.Fournisseur;

public class DonneesFournisseur {
	
	String nomFournisseur = null;
	Fournisseur iorFournisseur = null;
	
	public DonneesFournisseur(String pNomFournisseur, Fournisseur pIorFournisseur){
		nomFournisseur = pNomFournisseur;
		iorFournisseur = pIorFournisseur;
	}

	public synchronized String getNomFournisseur(){
		return nomFournisseur;
	}
	
	public synchronized Fournisseur getIorFournisseur(){
		return iorFournisseur;
	}
}
