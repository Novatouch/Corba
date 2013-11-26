package corba;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;


public class Corba {

	// variable stockant l'arbre orb
	private org.omg.CORBA.ORB orb = null;
	
	private org.omg.CosNaming.NamingContext nameRoot = null;
	
	POA rootPOA = null;
	
	public Corba (String[] pargs){
		// Intialisation de l'orb
		orb = org.omg.CORBA.ORB.init(pargs,null);
		recupererNameRoot();
		resolutionPOA();
		activationPOA();
		
	}
	
	
	private void recupererNameRoot(){
		 
		try {
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
		} catch (InvalidName e1) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: La communication avec le naming service CORBA a echoue");
		}
	}
	
	
	
	private void resolutionPOA(){
		try {
			
			rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		} catch (InvalidName e) {
			System.out.println("ERROR : initialisation du POA a echoué");
		}
	}
	
	private void activationPOA(){
		try {
			rootPOA.the_POAManager().activate();
		} catch (AdapterInactive e) {
			System.out.println("ERREUR : Le POA n'a pu être activé");
		}
	}

	public void enregistrementServant(String pnom, org.omg.PortableServer.Servant pServant ){
		
		org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
		nameToRegister[0] = new org.omg.CosNaming.NameComponent(pnom,"");
		try {
			nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(pServant));
		} catch (NotFound | CannotProceed
				| org.omg.CosNaming.NamingContextPackage.InvalidName
				| ServantNotActive | WrongPolicy e) {
			System.out.println("ERROR : déclaration de l'objet "+ pnom +" a échouée");
		}
		
	}
	
	/*
	public Talk enregistrementObjetTalk(String pnom, TalkPOA pobjet ){
		
		String IORServant = null;
		
		org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
		nameToRegister[0] = new org.omg.CosNaming.NameComponent(pnom,"");
		try {
			nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(pobjet));
		} catch (NotFound | CannotProceed
				| org.omg.CosNaming.NamingContextPackage.InvalidName
				| ServantNotActive | WrongPolicy e) {
			System.out.println("ERROR : déclaration de l'objet "+ pnom +" a échouée");
		}
		
		// Commande debuggage
		//System.out.println("==> Nom '"+ nom + "' est enregistre dans le service de noms.");

		
		try {
			IORServant = orb.object_to_string(rootPOA.servant_to_reference(pobjet));
		} catch (ServantNotActive | WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// recuperation object corba
		org.omg.CORBA.Object distantMonTalk = orb.string_to_object(IORServant);
        // Casting de l'objet CORBA au type convertisseur euro
		
		return  GoogleTalk.TalkHelper.narrow(distantMonTalk);
	}
	
	
	private static org.omg.CORBA.Object resolutionObjetCorba(String pnomATrouver){
			
			// variable pour stocker la réference du serveur CHAT
			org.omg.CORBA.Object distantObjet = null;
			
			// Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(pnomATrouver,"");
	
	        // Recherche auprès du naming service
	        
	        
			try {
				distantObjet = nameRoot.resolve(nameToFind);
			} catch (NotFound | CannotProceed
					| org.omg.CosNaming.NamingContextPackage.InvalidName e) {
				System.out.println("La recherche de la référence de l'objet Corba ayant pour identifiant "+ pnomATrouver +" du Name service à échouée");
			}
			
			return distantObjet;
			
	}
	*/
	
	public void run(){
		orb.run();
	}
	

	
}
