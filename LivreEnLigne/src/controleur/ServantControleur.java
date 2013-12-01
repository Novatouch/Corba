package controleur;

import commun.Debug;

import LivreEnLigne.ControleurPOA;
import LivreEnLigne.ExceptionAuthorizationFailed;

public class ServantControleur extends ControleurPOA {

	ListeEnregistrement liste = null;
	
	public ServantControleur(ListeEnregistrement pListe){
		liste = pListe;
	}
	
	@Override
	public String verifierAutorisation(String pAuteur, String pTitre,
			String pUtilisateur, String pFournisseur)
			throws ExceptionAuthorizationFailed {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enregistrerPret(String pUtilisateurPreteur,
			String pUtilisateurEmprunteur, String pTitre, String pAuteur,
			String pFournisseur) {
		
		
		
	}

	@Override
	public void enregistrerAchat(String pUtilisateur, String pTitre,
			String pAuteur, String pFournisseur) {
		
		Debug.afficherLog("info","Reception requete enregistrerAchat");
		
		CommandeControleur commande = new CommandeControleur(pUtilisateur, pTitre, pAuteur, pFournisseur);
		
		Debug.afficherLog("info","ajout de la commande à la liste d'enregistrement code enregistrement :" + pTitre + pAuteur + pFournisseur + pUtilisateur);
		// titre + auteur + fournisseur + achetteur
		liste.ajouterEnregistrement(commande);
	}

	@Override
	public void validerPret(String pUtilisateurPreteur,
			String pUtilisateurEmprunteur, String pTitre, String pAuteur,
			String pFournisseur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirerPret(String pUtilisateurPreteur,
			String pUtilisateurEmprunteur, String pFournisseur, String pTitre,
			String pAuteur) {
		// TODO Auto-generated method stub
		
	}

}
