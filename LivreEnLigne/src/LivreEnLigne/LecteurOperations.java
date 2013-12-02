package LivreEnLigne;

/**
 * Interface definition : Lecteur
 * 
 * @author OpenORB Compiler
 */
public interface LecteurOperations
{
    /**
     * Operation miseAjourLivre
     */
    public void miseAjourLivre(String pTitre, String pAuteur, String pFournisseur)
        throws LivreEnLigne.ExceptionMiseAJourLivre;

    /**
     * Operation confirmerTelechargement
     */
    public void confirmerTelechargement(String pTitre, String pAuteur, String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur);

    /**
     * Operation recevoirPret
     */
    public void recevoirPret(String pTitre, String pAuteur, String pContenu, String pCle);

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pTitre, String pAuteur);

}
