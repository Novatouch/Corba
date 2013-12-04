package lecteur;

import commun.Debug;

import LivreEnLigne.ExceptionMiseAJourLivre;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.LecteurPOA;
import LivreEnLigne.LivreChiffre;

public class ServantLecteur extends LecteurPOA {

	private String nomLecteur = null;
	private Bibliotheque bibliotheque = null;
	
	
	public ServantLecteur(String nomLecteur, Bibliotheque pBibliotheque) {
		super();
		this.nomLecteur = nomLecteur;
		this.bibliotheque = pBibliotheque;
	}

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
			String pNomFournisseur, Fournisseur pIorFournisseur) {
		
			Debug.afficherLog("info","reception Confirmation Telechargement titre :" + pTitre + " auteur :" + pAuteur + " fournisseur : " + pNomFournisseur);
			
			Debug.afficherLog("info","telechargement de l'oeuvre");
			LivreChiffre livreChiffre = pIorFournisseur.telechargerLivre(pTitre, pAuteur, nomLecteur);
			
			Debug.afficherLog("info","cle : " + livreChiffre.cle + " contenu livre : " + livreChiffre.contenu);
			
			Debug.afficherLog("info","enregistrement du livre dans la bibliotheque");
			
			LivreUtilisateur livreUtilisateur;
			try {
				livreUtilisateur = bibliotheque.rechercherLivre(pTitre, pAuteur, pNomFournisseur);
				
				livreUtilisateur.setContenu(livreChiffre.contenu);
				livreUtilisateur.setCle(livreChiffre.cle);
				livreUtilisateur.setEstTelecharger(true);
				
			} catch (ExceptionNoLivreInBibliotheque e) {
				Debug.afficherLog("error","Livre introuvable dans la bibliotheque, impossible de sauvegarder le contenu");
			}	
	}
}
