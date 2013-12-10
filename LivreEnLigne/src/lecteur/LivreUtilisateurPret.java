package lecteur;

import java.util.Date;

import LivreEnLigne.Fournisseur;

public class LivreUtilisateurPret extends LivreUtilisateurVirtual {

	private long debutEmprunt;
	private String nomProprietaire;
	
	public LivreUtilisateurPret(String pAuteur, String pTitre, String pContenu, short pCle,
			String pNomFournisseur, Fournisseur pIorFournisseur, String pNomProprietaire) {
		super(pAuteur, pTitre, pContenu,  pNomFournisseur, pIorFournisseur);
		debutEmprunt = System.currentTimeMillis( );
		nomProprietaire = pNomProprietaire;
		this.cle = pCle;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public void lecturePossible() throws ExceptionPretEstTropOld, ExceptionLivreNotTelecharge{
		
		long dureeEmprunt = System.currentTimeMillis() - debutEmprunt; 
		long month2 = 2 * 30 * 24 * 60 * 60 * 100;
		
		if(estTelecharger == true){
			
			if(dureeEmprunt > month2){
				throw new ExceptionPretEstTropOld();
			}
		}
		else {
			// livre non telecharge
			throw new ExceptionLivreNotTelecharge();
		}
		
		
	}
}
