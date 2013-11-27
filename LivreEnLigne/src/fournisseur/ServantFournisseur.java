package fournisseur;

import LivreEnLigne.ExceptionEchecCommande;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.FournisseurPOA;
import LivreEnLigne.InfoBancaires;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.LivreChiffre;
import corba.CorbaLivreEnLigne;

public class ServantFournisseur extends FournisseurPOA {

	private CorbaLivreEnLigne corbaManager = null;
	private String nomFournisseur = null;
	private Catalogue catalogue = null;
	//private Fournisseur iorFournisseur = null;
	
	ServantFournisseur(String pNomFournisseur, CorbaLivreEnLigne pCorbaManager, Catalogue pCatalogue){
		
		corbaManager = pCorbaManager;
		nomFournisseur = pNomFournisseur;
		catalogue = pCatalogue;
		//iorFournisseur = pIorFournisseur;
		
	}

	@Override
	public float rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound {
		
		return catalogue.rechercherPrix(pAuteur, pTitre);
	}

	@Override
	public void commander(String pTitre, String pAuteur, InfoBancaires pInfo,String pUtilisateur) throws ExceptionEchecCommande {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LivreChiffre telechargerLivre(String pUtilisateur, String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		
	}

}
