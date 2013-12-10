package LivreEnLigne;

/**
 * Interface definition : Controleur
 * 
 * @author OpenORB Compiler
 */
public interface ControleurOperations
{
    /**
     * Operation verifierAutorisation
     */
    public void verifierAutorisation(String pTitre, String pAuteur, String pUtilisateur, String pFournisseur)
        throws LivreEnLigne.ExceptionAuthorizationFailed;

    /**
     * Operation verifierAutorisationPret
     */
    public void verifierAutorisationPret(String pTitre, String pAuteur, String pUtilisateurProprietaire, String pUtilisateurEmprunteur, String pFournisseur)
        throws LivreEnLigne.ExceptionAuthorizationFailed;

    /**
     * Operation enregistrerPret
     */
    public void enregistrerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur, String pFournisseur)
        throws LivreEnLigne.ExceptionPretNotSaved;

    /**
     * Operation enregistrerAchat
     */
    public void enregistrerAchat(String pUtilisateur, String pTitre, String pAuteur, String pFournisseur);

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pFournisseur, String pTitre, String pAuteur);

    /**
     * Operation flush
     */
    public void flush();

}
