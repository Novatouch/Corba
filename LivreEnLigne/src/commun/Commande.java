package commun;

import java.util.Date;

import LivreEnLigne.Lecteur;

public class Commande {
	
	private String achetteur = null;

	private String preteur = null;

	private Date debutPret = null;
	
	public Commande(String achetteur, String preteur) {

		this.achetteur = achetteur;
		this.preteur = preteur;
	}
	
	public Commande(String achetteur) {

		this.achetteur = achetteur;
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

	public Date getDebutPret() {
		return debutPret;
	}

	public void setDebutPret(Date debutPret) {
		this.debutPret = debutPret;
	}
}
