package lecteur;

import commun.Debug;

import corba.CorbaLivreEnLigne;
import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.Mandataire;

public class InterfaceLivreEnLigne {

	Mandataire iorMandataire;
	CorbaLivreEnLigne corbaManager;
	
	public InterfaceLivreEnLigne(String pMandataire, CorbaLivreEnLigne pCorbaManager){
		
		corbaManager = pCorbaManager;
		// resolution iorMandataire
		Debug.afficherLog("info","Résolution du Mandataire auprès du serveur de nommage");
		iorMandataire = corbaManager.resolveObjetMandataire(pMandataire);
	}
	
	public InfoRecherche rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound{
	
			InfoRecherche resultat = iorMandataire.rechercherLivre("titre1", "auteur1");
						
			return resultat;
	}
}
