package lecteur;

import commun.Debug;

import LivreEnLigne.ExceptionMiseAJourLivre;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.LecteurPOA;
import LivreEnLigne.LivreChiffre;

public class ServantLecteur extends LecteurPOA {

	private String nomLecteur = null;
	private Bibliotheque bibliotheque = null;
	private Bibliotheque bibliothequePret = null;
	
	
	public ServantLecteur(String nomLecteur, Bibliotheque pBibliotheque, Bibliotheque pBibliothequePret) {
		super();
		this.nomLecteur = nomLecteur;
		this.bibliotheque = pBibliotheque;
		this.bibliothequePret = pBibliothequePret;
	}

	@Override
	public void miseAjourLivre( String pTitre, String pAuteur,
			String pFournisseur) throws ExceptionMiseAJourLivre {
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

	@Override
	public void recevoirPret(String pTitre, String pAuteur,
			String pNomProprietaire, String pNomFournisseur,
			Fournisseur pIorFournisseur) {
		
		Debug.afficherLog("info","reception Confirmation TelechargementPret titre :" + pTitre + " auteur :" + pAuteur + " pNomProprietaire : " + pNomProprietaire);
		LivreChiffre livreChiffre = pIorFournisseur.telechargerLivrePret(pTitre, pAuteur, pNomProprietaire, nomLecteur);
		
		short cle = livreChiffre.cle;
		String contenu = livreChiffre.contenu;
		Debug.afficherLog("info","cle : " + cle + " contenu livre : " + contenu);
		
		Debug.afficherLog("info","enregistrement du livre dans la bibliothequePret");
		
		LivreUtilisateurPret livre = new LivreUtilisateurPret(pAuteur, pTitre, contenu, cle, pNomFournisseur, pIorFournisseur,  pNomProprietaire);
		livre.setEstTelecharger(true);
		bibliothequePret.ajouterLivrePret(livre);
	}

	@Override
	public void retirerPret(String pTitre, String pAuteur,
			String pNomProprietaire) {
		Debug.afficherLog("info","ServantLecteur > retirerPret: reception suppresion enregistrement : " + pTitre + pAuteur + pNomProprietaire);
		
		try {
			bibliothequePret.supprimerPret(pTitre, pAuteur, pNomProprietaire);
			Debug.afficherLog("info","ServantLecteur > retirerPret: pret retiré");
		} catch (ExceptionNoLivreFound e) {
			Debug.afficherLog("error","ServantLecteur > retirerPret: suppresion pret echoue");
		}
	}
}
