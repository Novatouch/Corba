package corba;

import LivreEnLigne.Banque;
import LivreEnLigne.Controleur;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.Lecteur;
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
	
	public Banque resolveObjetBanque(String pNom){
		
		Banque objetBanque = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetBanque = (Banque) LivreEnLigne.BanqueHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetBanque;
	}
	
	public Controleur resolveObjetControleur(String pNom){
		
		Controleur objetControleur = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetControleur = (Controleur) LivreEnLigne.ControleurHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetControleur;
	}
	
	public Lecteur resolveObjetLecteur(String pNom){
		
		Lecteur objetLecteur = null;
		// variable pour stocker la réference du serveur CHAT
		
		objetLecteur = (Lecteur) LivreEnLigne.LecteurHelper.narrow(resolutionObjetCorba(pNom));
				
		return objetLecteur;
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
