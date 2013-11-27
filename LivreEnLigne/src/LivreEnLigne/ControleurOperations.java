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
    public String verifierAutorisation(String pAuteur, String pTitre, String pUtilisateur, String pFournisseur)
        throws LivreEnLigne.ExceptionAuthorizationFailed;

    /**
     * Operation enregistrerPret
     */
    public void enregistrerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur, String pFournisseur);

    /**
     * Operation enregistrerAchat
     */
    public void enregistrerAchat(String pUtilisateur, String pTitre, String pAuteur, String pFournisseur);

    /**
     * Operation validerPret
     */
    public void validerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur, String pFournisseur);

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pFournisseur, String pTitre, String pAuteur);

}
