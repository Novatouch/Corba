package commun;

public class Livre {

	
	protected String auteur = null;
	protected String titre = null;
	protected String contenu = null;
	
	public Livre(String pAuteur, String pTitre, String pContenu) {
		
		this.auteur = pAuteur;
		this.titre = pTitre;
		this.contenu = pContenu;
	}

	 public synchronized String getAuteur() {
		return auteur;
	}

	public synchronized void setAuteur(String pAuteur) {
		this.auteur = pAuteur;
	}

	public synchronized String getTitre() {
		return titre;
	}

	public synchronized void setTitre(String pTitre) {
		this.titre = pTitre;
	}

	public synchronized String getContenu() {
		return contenu;
	}

	public synchronized void setContenu(String pContenu) {
		this.contenu = pContenu;
	}
	
}
