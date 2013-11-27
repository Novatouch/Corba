package mandataire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LivreEnLigne.Fournisseur;

public class ListeFournisseur {

	
	private List<DonneesFournisseur> list = null;
	
	ListeFournisseur(){
		 list = Collections.synchronizedList(new ArrayList<DonneesFournisseur>());
	}
	
	public void  ajouterFournisseur(String pNom, Fournisseur pIorFournisseur){
		
		DonneesFournisseur maillon = new DonneesFournisseur(pNom, pIorFournisseur);
		list.add(maillon);
	}
	
	public List<DonneesFournisseur> getList(){
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
