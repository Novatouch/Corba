package corba;

public class CorbaLivreEnLigne extends Corba{

	public CorbaLivreEnLigne(String[] pargs) {
		super(pargs);
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
