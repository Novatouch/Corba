package LivreEnLigne;

/**
 * Interface definition : Fournisseur
 * 
 * @author OpenORB Compiler
 */
public interface FournisseurOperations
{
    /**
     * Operation rechercherLivre
     */
    public float rechercherLivre(String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionNoLivreFound;

    /**
     * Operation commander
     */
    public void commander(String pTitre, String pAuteur, String pCompte, String pCode, String pLecteur, LivreEnLigne.Lecteur pIorLecteur)
        throws LivreEnLigne.ExceptionEchecCommande;

    /**
     * Operation telechargerLivre
     */
    public LivreEnLigne.LivreChiffre telechargerLivre(String pTitre, String pAuteur, String pUtilisateurProprietaire);

    /**
     * Operation telechargerLivrePret
     */
    public LivreEnLigne.LivreChiffre telechargerLivrePret(String pTitre, String pAuteur, String pUtilisateur, String pUtilisateurEmprunteur);

    /**
     * Operation creerPret
     */
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, LivreEnLigne.Lecteur pIorUtilisateurEmprunteur, String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionPretNotAllowed;

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, LivreEnLigne.Lecteur pIorUtilisateurEmprunteur, String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionPretNotDeleted;

    /**
     * Operation flush
     */
    public void flush();

}
