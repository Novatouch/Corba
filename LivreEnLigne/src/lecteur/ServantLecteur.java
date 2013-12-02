package lecteur;

import commun.Debug;

import LivreEnLigne.ExceptionMiseAJourLivre;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.LecteurPOA;

public class ServantLecteur extends LecteurPOA {

	@Override
	public void miseAjourLivre( String pTitre, String pAuteur,
			String pFournisseur) throws ExceptionMiseAJourLivre {
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

	@Override
	public void confirmerTelechargement(String pTitre, String pAuteur,
			String pFournisseur, Fournisseur pIorFournisseur) {
		
			Debug.afficherLog("info","reception Confirmation Telechargement titre :" + pTitre + " auteur :" + pAuteur + " fournisseur : " + pFournisseur);
	}
}
