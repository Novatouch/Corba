package fournisseur;

import LivreEnLigne.Fournisseur;
import LivreEnLigne.Lecteur;

import commun.Debug;

public class ChiffrementWorkerAchat implements Runnable{

	private ListeTelechargement listeTelechargement;
	private String nomServeur = null;
	private Fournisseur iorFournisseur = null;
	
	public ChiffrementWorkerAchat(ListeTelechargement pListeTelechargement, String pNomServeur, Fournisseur  pIorFournisseur){
		listeTelechargement = pListeTelechargement;
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
				Telechargement objetTelechargement = listeTelechargement.rechercheLivreAChiffrer();
				
				Debug.afficherLog("info","thread chiffrement > livre a chiffre détecté");
				
				chiffrementLivre(objetTelechargement);
				
				// notification au client
				Lecteur IorAchetteur = objetTelechargement.getCommandeFournisseur().getIorAchetteur();
				String titre = objetTelechargement.getCommandeFournisseur().getLivre().getTitre();
				String auteur = objetTelechargement.getCommandeFournisseur().getLivre().getAuteur();
				
				Debug.afficherLog("info","thread chiffrement > chiffrement terminé");
				Debug.afficherLog("info","thread chiffrement > envoi de la confirmation au client");
				IorAchetteur.confirmerTelechargement(titre, auteur, nomServeur, iorFournisseur);
								
				
			} catch (ExceptionNoLivreToEncrypt e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
					Debug.afficherLog("error","Mise en attente du thread chiffrement impossible");
					continuer = false;
				}
			}
		}
	}
}
