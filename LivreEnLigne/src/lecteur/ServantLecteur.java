package lecteur;

import LivreEnLigne.ExceptionMiseAJourLivre;
import LivreEnLigne.LecteurPOA;

public class ServantLecteur extends LecteurPOA {

	@Override
	public void miseAjourLivre(String pAuteur, String pTitre,
			String pFournisseur) throws ExceptionMiseAJourLivre {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmerTelechargement(String pAuteur, String pTitre,
			String pFournisseur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recevoirPret(String pTitre, String pAuteur, String pContenu,
			String pCle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirerPret(String pTitre, String pAuteur) {
		// TODO Auto-generated method stub
		
	}

}
