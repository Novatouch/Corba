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
    public void miseAjourLivre(String pTitre, String pAuteur, String pFournisseur, LivreEnLigne.LivreChiffre pLivre)
        throws LivreEnLigne.ExceptionMiseAJourLivre;

    /**
     * Operation miseAjourLivrePret
     */
    public void miseAjourLivrePret(String pTitre, String pAuteur, String pNomProprietaire, String pFournisseur, LivreEnLigne.LivreChiffre pLivre)
        throws LivreEnLigne.ExceptionMiseAJourLivrePret;

    /**
     * Operation confirmerTelechargement
     */
    public void confirmerTelechargement(String pTitre, String pAuteur, String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur);

    /**
     * Operation recevoirPret
     */
    public void recevoirPret(String pTitre, String pAuteur, String pNomProprietaire, String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur);

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pTitre, String pAuteur, String pNomProprietaire);

}
