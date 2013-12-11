package commun;

import java.util.Date;

import LivreEnLigne.Lecteur;

public class Commande {
	
	private String achetteur = null;

	private String preteur = null;

	protected long debutPret;
	
	protected Boolean estPrete = false;
	
	public Commande(String achetteur, String preteur) {

		this.achetteur = achetteur;
		this.preteur = preteur;
		debutPret = System.currentTimeMillis();
	}
	
	public Commande(String achetteur) {

		this.achetteur = achetteur;
		estPrete = false;
	}

	public String getAchetteur() {
		return achetteur;
	}

	public void setAchetteur(String achetteur) {
		this.achetteur = achetteur;
	}

	public String getPreteur() {
		return preteur;
	}

	public void setPreteur(String preteur) {
		this.preteur = preteur;
	}

	public long getDebutPret() {
		return debutPret;
	}

	public Boolean getEstPrete() {
		return estPrete;
	}

	public void setDebutPret() {
		this.debutPret = System.currentTimeMillis();
	}
	
	public void setEstPrete(Boolean pBool) {
		this.estPrete = pBool;
	}
	
	public void estPretable() throws ExceptionLivreNotPretable{
		
		long duree = System.currentTimeMillis() - debutPret;
		long month2 = 30 * 24 * 60 *60 * 100;
		
		if (estPrete == true && duree < month2){
			throw new ExceptionLivreNotPretable();
		}
	}
}
