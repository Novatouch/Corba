package corba;

import LivreEnLigne.Fournisseur;
import LivreEnLigne.Mandataire;

public class CorbaLivreEnLigne extends Corba{

	public CorbaLivreEnLigne(String[] pargs) {
		super(pargs);
	}

	public Fournisseur resolveObjetFournisseur(String pNom){
		
		Fournisseur objetFournisseur = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetFournisseur = (Fournisseur) LivreEnLigne.FournisseurHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetFournisseur;
	}
	
	public Mandataire resolveObjetMandataire(String pNom){
		
		Mandataire objetMandataire = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetMandataire = (Mandataire) LivreEnLigne.MandataireHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetMandataire;
	}
	
	/*
	public Chat resolveObjetChat(String pNom){
		
		Chat objetChat = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetChat = (Chat) GoogleTalk.ChatHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetChat;
	}
	
	public Talk resolveObjetTalk(String pNom){
		
		Talk objetTalk = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetTalk = (Talk) GoogleTalk.TalkHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetTalk;
	}
	*/
}
