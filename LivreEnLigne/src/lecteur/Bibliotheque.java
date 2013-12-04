package lecteur;

import java.util.concurrent.ConcurrentHashMap;

import commun.Debug;

import LivreEnLigne.ExceptionNoLivreFound;


public class Bibliotheque {

	private ConcurrentHashMap<String,LivreUtilisateur> bibliotheque = null;
	
	public Bibliotheque(){
		bibliotheque = new ConcurrentHashMap<String,LivreUtilisateur>();
	}
	
	public void ajouterLivre(LivreUtilisateur pLivre){
		bibliotheque.put(pLivre.getTitre() + pLivre.getAuteur() + pLivre.getNomFournisseur(), pLivre);
		Debug.afficherLog("info","Bibliotheque : ajout d'un livre");
	}

	public ConcurrentHashMap<String, LivreUtilisateur> getBibliotheque() {
		return bibliotheque;
	}	
	
	public LivreUtilisateur rechercherLivre(String pTitre, String pAuteur, String pNomFournisseur) throws ExceptionNoLivreInBibliotheque{
		
		if (bibliotheque.containsKey(pTitre + pAuteur + pNomFournisseur) == false){
			throw new ExceptionNoLivreInBibliotheque();
		}
		return bibliotheque.get(pTitre + pAuteur + pNomFournisseur);
	}
}
