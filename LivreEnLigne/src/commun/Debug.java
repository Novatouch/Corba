package commun;

public class Debug {

	static public void afficherLog(String pCode, String pMessage ){
		
		switch (pCode) {
        case "info":
        	System.out.println("INFORMATION : "+ pMessage);
        	break;
        case "error":
        	System.out.println("ERREUR : "+ pMessage);
        	break;
        default:
        	System.out.println("Code inconnu !!!");
        	break;
		}
		
		
	}
}
