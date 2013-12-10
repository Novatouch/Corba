package LivreEnLigne;

/**
 * Interface definition : Mandataire
 * 
 * @author OpenORB Compiler
 */
public interface MandataireOperations
{
    /**
     * Operation rechercherLivre
     */
    public LivreEnLigne.InfoRecherche rechercherLivre(String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionNoLivreFound;

    /**
     * Operation enregistrementFournisseur
     */
    public void enregistrementFournisseur(String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur);

    /**
     * Operation flush
     */
    public void flush();

}
