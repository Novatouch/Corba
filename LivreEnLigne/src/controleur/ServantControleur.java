package controleur;

import commun.Debug;
import commun.ExceptionLivreNotPretable;

import LivreEnLigne.ControleurPOA;
import LivreEnLigne.ExceptionAuthorizationFailed;
import LivreEnLigne.ExceptionPretNotSaved;

public class ServantControleur extends ControleurPOA {

	ListeEnregistrement liste = null;
	
	public ServantControleur(ListeEnregistrement pListe){
		liste = pListe;
	}
	
	@Override
	public void enregistrerAchat(String pUtilisateur, String pTitre,
			String pAuteur, String pFournisseur) {
		
		Debug.afficherLog("info","ServantControleur > enregistrerAchat : Reception requete enregistrerAchat");
		
		CommandeControleur commande = new CommandeControleur(pUtilisateur, pTitre, pAuteur, pFournisseur);
		
		Debug.afficherLog("info","ServantControleur > enregistrerAchat : ajout de la commande à la liste d'enregistrement code enregistrement :" + pTitre + pAuteur + pFournisseur + pUtilisateur);
		// titre + auteur + fournisseur + achetteur
		liste.ajouterEnregistrement(commande);
	}


	@Override
	public void retirerPret(String pUtilisateurPreteur,
			String pUtilisateurEmprunteur, String pFournisseur, String pTitre,
			String pAuteur) {
		
		Debug.afficherLog("info","ServantControleur > retirerPret : supression enregistrement : " + pTitre + pAuteur + pFournisseur + pUtilisateurPreteur);
		try {
			
			liste.supprimerEnregistrement(pTitre, pAuteur, pFournisseur, pUtilisateurPreteur);
			Debug.afficherLog("info","ServantControleur > retirerPret : supression de pret effectue");
					
		} catch (ExceptionEnregistrementNotFound e) {

			Debug.afficherLog("error","ServantControleur > retirerPret : aucun enregistrement trouve");
		}
		
	}



	@Override
	public void verifierAutorisation(String pTitre, String pAuteur,
			String pNomAchetteur, String pNomFournisseur)
			throws ExceptionAuthorizationFailed {
		
		Debug.afficherLog("info","ServantControleur > verifierAutorisation : identifiant enregistrement : " + pTitre + pAuteur + pNomFournisseur + pNomAchetteur);
		try {
			liste.verifierExistenceEnregistrement(pTitre, pAuteur, pNomFournisseur, pNomAchetteur);
			
		} catch (ExceptionEnregistrementNotFound e) {

			Debug.afficherLog("error","ServantControleur > verifierAutorisation : aucun enregistrement trouve");
			throw new ExceptionAuthorizationFailed();
		}
	}



	@Override
	public void flush() {
		Debug.afficherLog("info","ServantControleur > flush : flush de la liste des enregistrements");
		liste.flush();
	}

	@Override
	public void enregistrerPret(String pUtilisateurPreteur,
			String pUtilisateurEmprunteur, String pTitre, String pAuteur,
			String pFournisseur) throws ExceptionPretNotSaved {
		
		Debug.afficherLog("info","ServantControleur > enregistrerPret : identifiant enregistrement commande: " + pTitre + pAuteur + pFournisseur + pUtilisateurPreteur +" utilisateur Emprunteur : " + pUtilisateurEmprunteur);
		
		try {
			
			Debug.afficherLog("info","ServantControleur > enregistrerPret : recherche commande");
			// retrouver la commande a modifié
			CommandeControleur commande = liste.rechercherEnregistrement(pTitre, pAuteur, pFournisseur, pUtilisateurPreteur);
			
			Debug.afficherLog("info","ServantControleur > enregistrerPret : commande trouvée");
			
			// verifier si le pret peut être validé
			try {
				
				Debug.afficherLog("info","ServantControleur > enregistrerPret : verification si utilisateur peut  prêter sa commande");
				
				commande.estPretable();

				Debug.afficherLog("info","ServantControleur > enregistrerPret : mise à jour info commande");
				// ajout des informations de pret
				commande.setPreteur(pUtilisateurEmprunteur);
				commande.setEstPrete(true);
				commande.setDebutPret();
				
				Debug.afficherLog("info","ServantControleur > enregistrerPret : prêt enregistré");
				
			
			} catch (ExceptionLivreNotPretable e) {
				
				Debug.afficherLog("error","ServantControleur > enregistrerPret : La commande ne permet pas de pret");
				// livre non pretable
				throw new ExceptionPretNotSaved();
			}
			
			
		} catch (ExceptionEnregistrementNotFound e) {
			
			Debug.afficherLog("error","ServantControleur > enregistrerPret : La commande n'a pas été trouvée dans la base d'enregistrements");
			// enregistrement introuveable
			throw new ExceptionPretNotSaved();
		}
		
	}


	@Override
	public void verifierAutorisationPret(String pTitre, String pAuteur,
			String pUtilisateurProprietaire, String pUtilisateurEmprunteur,
			String pFournisseur) throws ExceptionAuthorizationFailed {
		Debug.afficherLog("info","ServantControleur > verifierAutorisationPret : enregistrement demande " + pTitre + pAuteur + pFournisseur + pUtilisateurProprietaire);
		try {
			CommandeControleur commande = liste.rechercherEnregistrement(pTitre, pAuteur, pFournisseur, pUtilisateurProprietaire);
			
			// verifie le nom de l'emprunteur dans la commande
			if (commande.getPreteur().contentEquals(pUtilisateurEmprunteur) == true){
				try {
					
					// verifie si le pret est encore valide
					commande.pretValide();
					
					Debug.afficherLog("info","ServantControleur > verifierAutorisationPret : pret autorisé");
					
				} catch (ExceptionPretNotValide e) {
					
					Debug.afficherLog("error","ServantControleur > verifierAutorisationPret : la durée du pret à expirée");
					// le pret n'est plus valide
					throw new ExceptionAuthorizationFailed("plop");
				}
			}else {
				
				Debug.afficherLog("error","ServantControleur > verifierAutorisationPret : le nom du prêteur n'est pas présent dans l'enregistrement");
				// nom preteur n'est pas le même dans la commande
				throw new ExceptionAuthorizationFailed("plop");
			}
			
		} catch (ExceptionEnregistrementNotFound e) {
			
			Debug.afficherLog("error","ServantControleur > verifierAutorisationPret : l'enregistrement n'a pas été trouvé");
			// comande introuvable
			throw new ExceptionAuthorizationFailed("plop");
		}
	}
}
