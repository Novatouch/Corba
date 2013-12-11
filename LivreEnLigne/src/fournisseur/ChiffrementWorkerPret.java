package fournisseur;

import LivreEnLigne.ExceptionMiseAJourLivrePret;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.Lecteur;
import LivreEnLigne.LivreChiffre;

import commun.Debug;

public class ChiffrementWorkerPret implements Runnable{


	private ListeTelechargement listeTelechargementPret;
	private String nomServeur = null;
	private Fournisseur iorFournisseur = null;
	
	public ChiffrementWorkerPret( ListeTelechargement pListeTelechargementPret, String pNomServeur, Fournisseur  pIorFournisseur){

		listeTelechargementPret = pListeTelechargementPret;
		nomServeur = pNomServeur;
		iorFournisseur = pIorFournisseur;
	}

	private void chiffrementLivre(Telechargement pObjetTelechargement){
		// mise à jour des flags
		pObjetTelechargement.setaChiffre(false);
		pObjetTelechargement.setEnCoursDeChiffrement(true);
		
		// chiffrement du livre
		pObjetTelechargement.chiffrementContenuLivre();
		// mise à jour du flag
		pObjetTelechargement.setEnCoursDeChiffrement(false);
		pObjetTelechargement.setaEnvoyer(true);
	}
	
	@Override
	public void run() {

		boolean continuer = true;
		
		while(continuer){
			try {
				
				// parcour de la liste et recherche d'un livre à chiffrer
				Telechargement objetTelechargement = listeTelechargementPret.rechercheLivreAChiffrer();
				
				Debug.afficherLog("info","thread chiffrement pret > livre a chiffre détecté");
				
				chiffrementLivre(objetTelechargement);
				
				// notification au client
				Lecteur IorEmprunteur = objetTelechargement.getCommandeFournisseur().getIorEmprunteur();
				String titre = objetTelechargement.getCommandeFournisseur().getLivre().getTitre();
				String auteur = objetTelechargement.getCommandeFournisseur().getLivre().getAuteur();
				String utilisateurPreteur = objetTelechargement.getCommandeFournisseur().getAchetteur();
				
				Debug.afficherLog("info","thread chiffrement Pret > chiffrement terminé");
				Debug.afficherLog("info","thread chiffrement Pret > envoi de la confirmation au client");
				
				// envoyer la requete à l'utilisateur preteur
				
				
				if (objetTelechargement.getMiseAjour() == true){
					
					try {
						Debug.afficherLog("info","thread chiffrement Pret > appel fonction miseAjourLivrePret de l'emprunteur");
						LivreChiffre livreChiffre = objetTelechargement.getLivreChiffre();
						
						IorEmprunteur.miseAjourLivrePret(titre, auteur, utilisateurPreteur, nomServeur, livreChiffre);
					} catch (ExceptionMiseAJourLivrePret e) {
						Debug.afficherLog("info","thread chiffrement Pret > mise a jour echouée");
					}
				}
				else {
					Debug.afficherLog("info","thread chiffrement Pret > appel fonction recevoirPret");
					IorEmprunteur.recevoirPret(titre, auteur, utilisateurPreteur, nomServeur, iorFournisseur);
				}
				
			} catch (ExceptionNoLivreToEncrypt e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
					Debug.afficherLog("error","thread chiffrement Pret > Mise en attente du thread chiffrement impossible");
					continuer = false;
				}
			}
		}
	}
}
