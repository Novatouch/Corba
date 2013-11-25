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
        throws LivreEnLigne.NoLivre;

    /**
     * Operation commander
     */
    public void commander(String pTitre, String pAuteur, LivreEnLigne.InfoBancaires pInfo, String pUtilisateur)
        throws LivreEnLigne.EchecCommande;

    /**
     * Operation telechargerLivre
     */
    public LivreEnLigne.LivreChiffre telechargerLivre(String pUtilisateur, String pTitre, String pAuteur);

    /**
     * Operation creerPret
     */
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur);

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur);

}
