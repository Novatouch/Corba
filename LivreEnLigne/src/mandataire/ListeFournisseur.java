package mandataire;

import java.util.concurrent.ConcurrentHashMap;


import LivreEnLigne.Fournisseur;

public class ListeFournisseur {

	private ConcurrentHashMap<String,DonneesFournisseur> list;

	
	ListeFournisseur(){
		 list = new ConcurrentHashMap<String,DonneesFournisseur>();
	}
	
	public void  ajouterFournisseur(String pNom, Fournisseur pIorFournisseur){
		
		DonneesFournisseur maillon = new DonneesFournisseur(pNom, pIorFournisseur);
		list.put(pNom, maillon);
	}
	
	public ConcurrentHashMap getList(){
		return list;
	}
	
	
	
	/*
	List list = Collections.synchronizedList(new ArrayList());
	
	synchronized (list) {
	    Iterator i = list.iterator(); // Must be in synchronized block
	    while (i.hasNext())
	        foo(i.next());
	}
	*/
	  
	  
}
