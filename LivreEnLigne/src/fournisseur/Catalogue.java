package fournisseur;

import java.util.concurrent.ConcurrentHashMap;

import LivreEnLigne.ExceptionNoLivreFound;

public class Catalogue {

	private ConcurrentHashMap<String,LivreCatalogue> catalogue;
    
    public Catalogue(){
    	catalogue = new ConcurrentHashMap<String,LivreCatalogue>();
    }
    
    public void ajouterLivre(String pAuteur, String pTitre, String pContenu, Float pPrix, Boolean pEnVente){
    	
    	LivreCatalogue nouveauLivre = new LivreCatalogue(pAuteur, pTitre, pContenu, pPrix, pEnVente);
    	String codeUnique = pAuteur + pTitre;
    	
    	catalogue.put(codeUnique, nouveauLivre);
    }
    
    public void ajouterLivre(LivreCatalogue pNouveauLivre){
    	
    	String codeUnique = pNouveauLivre.getAuteur() + pNouveauLivre.getTitre();
    	catalogue.put(codeUnique, pNouveauLivre);
    }
    
    public LivreCatalogue rechercherLivre(String pAuteur, String pTitre) throws ExceptionNoLivreFound{
    	
    	LivreCatalogue livre = catalogue.get(pAuteur + pTitre);
    	
    	if (livre == null){
    		throw new ExceptionNoLivreFound("Le livre ne fait pas partie du catalogue");
    	}
    	else {
    		return livre;
    	}
    }
    
    public Float rechercherPrix(String pAuteur, String pTitre) throws ExceptionNoLivreFound{
    	
    	LivreCatalogue livre = catalogue.get(pAuteur + pTitre);
    	
    	if (livre == null){
    		throw new ExceptionNoLivreFound("Le livre ne fait pas partie du catalogue");
    	}
    	else {
    		return livre.getPrix();
    	}
    }
}
