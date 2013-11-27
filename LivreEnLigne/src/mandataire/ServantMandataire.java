package mandataire;

import java.util.Collection;
import java.util.Iterator;

import LivreEnLigne.ExceptionNoLivreFound;
import LivreEnLigne.Fournisseur;
import LivreEnLigne.InfoRecherche;
import LivreEnLigne.MandatairePOA;

import commun.Debug;

public class ServantMandataire extends MandatairePOA {

	private ListeFournisseur listeFournisseur = null ;
	
	ServantMandataire(ListeFournisseur pListeFournisseur){
		listeFournisseur = pListeFournisseur;
	}
	
	@Override
	public InfoRecherche rechercherLivre(String pTitre, String pAuteur) throws ExceptionNoLivreFound {
		
		InfoRecherche resultat = new InfoRecherche();
		resultat.prix =  -1;
		resultat.nomFournisseur = null;
		resultat.iorFournisseur = null;
		
		Debug.afficherLog("info","Reception requete recherche Livre titre" + pTitre + "auteur : " + pAuteur);
		
		// parcours de la liste des fournisseurs
		Collection<DonneesFournisseur> liste = listeFournisseur.getList().values();
        
        Iterator<DonneesFournisseur> iterator = liste.iterator();
        
        while(iterator.hasNext()){
                
        	DonneesFournisseur fourn = iterator.next();
        	
        	// Recherche du livre sur le fournisseur distant
        	Float prixFournisseur = null;
        	
        	try {
        		
        		Debug.afficherLog("info","Interrogation Fournisseur " + fourn.getNomFournisseur());
        		
				prixFournisseur = fourn.getIorFournisseur().rechercherLivre(pTitre, pAuteur);
				// si resultat

				Debug.afficherLog("info","Interrogation Fournisseur " + fourn.getNomFournisseur() + " livre disponible prix : " + prixFournisseur);
				
	        	   	
	        	
	        	// compraison avec le précédent résultat
	        	if (resultat.prix == -1 || prixFournisseur < resultat.prix ){
	        		
	        		resultat.prix = prixFournisseur;
		        	resultat.nomFournisseur	= fourn.getNomFournisseur();
		        	resultat.iorFournisseur = fourn.getIorFournisseur();  
	        	}
	        	
			} catch (ExceptionNoLivreFound e) {
				
				// ne rien faire
				Debug.afficherLog("info","Interrogation Fournisseur " + fourn.getNomFournisseur() + " pas de livre disponible");
			}
        }
        
        if (resultat.prix == -1 ){
        	
        	Debug.afficherLog("info","aucun résultat chez les fournisseur pour cette recherche");
        			
        	// génération d'une exeception dans le cas ou le mandataire n'a pas trouve de prix
        	throw new ExceptionNoLivreFound("Ce livre n'est pas présent chez aucun Fournisseur");
        	
        	
        }else {
        	
        	Debug.afficherLog("info","résultats recherche : " + resultat.nomFournisseur + " prix : " + resultat.prix);
        	
        	return resultat;
        }
	}

	@Override
	public void enregistrementFournisseur(String pFournisseur, Fournisseur pIorFournisseur) {
		
		// ajout des informations à la liste des fournisseurs
		listeFournisseur.ajouterFournisseur(pFournisseur, pIorFournisseur);
		Debug.afficherLog("info","Enregistrement fournisseur nom : " + pFournisseur);
	}

}
