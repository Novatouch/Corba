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
    public LivreEnLigne.LivreChiffre telechargerLivre(String pUtilisateur, LivreEnLigne.Lecteur IorUtulisateur, String pTitre, String pAuteur);

    /**
     * Operation creerPret
     */
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur);

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur);

}
