package lecteur;

import java.util.concurrent.ConcurrentHashMap;


public class Bibliotheque {

	private ConcurrentHashMap<String,LivreUtilisateur> bibliotheque = null;
	
	public Bibliotheque(){
		bibliotheque = new ConcurrentHashMap<String,LivreUtilisateur>();
	}
	
	public void ajouterLivre(LivreUtilisateur pLivre){
		bibliotheque.put(pLivre.getAuteur() + pLivre.getTitre() + pLivre.getNomFournisseur(), pLivre);
	}

	public ConcurrentHashMap<String, LivreUtilisateur> getBibliotheque() {
		return bibliotheque;
	}	
}
