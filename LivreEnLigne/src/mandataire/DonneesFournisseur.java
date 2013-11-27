package mandataire;

import LivreEnLigne.Fournisseur;

public class DonneesFournisseur {
	
	String nomFournisseur = null;
	Fournisseur iorFournisseur = null;
	
	DonneesFournisseur(String pNomFournisseur, Fournisseur pIorFournisseur){
		nomFournisseur = pNomFournisseur;
		iorFournisseur = pIorFournisseur;
	}

	String getNomFournisseur(){
		return nomFournisseur;
	}
	
	Fournisseur getIorFournisseur(){
		return iorFournisseur;
	}
}
