package mandataire;

import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.MandatairePOA;

public class ServantMandataire extends MandatairePOA {

	private ListeFournisseur listeFournisseur = null ;
	
	ServantMandataire(ListeFournisseur pListeFournisseur){
		listeFournisseur = pListeFournisseur;
	}
	
	@Override
	public InfoRecherche rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound {
		
		InfoRecherche resultat = null;
		Integer i = 1;
		
		if (i == 0){
			throw new ExceptionNoLivreFound("Ce livre n'est pas présent chez aucun Fournisseur");
		}
		else {
			resultat = new InfoRecherche("bla",null,10);
		}
		
		return resultat;
	}

	@Override
	public void enregistrementFournisseur(String pFournisseur, Fournisseur pIorFournisseur) {
		
		// ajout des informations à la liste des fournisseurs
		listeFournisseur.ajouterFournisseur(pFournisseur, pIorFournisseur);
	}

}
