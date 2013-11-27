package LivreEnLigne;

/**
 * Interface definition : Controleur
 * 
 * @author OpenORB Compiler
 */
public class ControleurPOATie extends ControleurPOA
{

    //
    // Private reference to implementation object
    //
    private ControleurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ControleurPOATie(ControleurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ControleurPOATie(ControleurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ControleurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ControleurOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation verifierAutorisation
     */
    public String verifierAutorisation(String pAuteur, String pTitre, String pUtilisateur, String pFournisseur)
        throws LivreEnLigne.ExceptionAuthorizationFailed
    {
        return _tie.verifierAutorisation( pAuteur,  pTitre,  pUtilisateur,  pFournisseur);
    }

    /**
     * Operation enregistrerPret
     */
    public void enregistrerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur, String pFournisseur)
    {
        _tie.enregistrerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur,  pFournisseur);
    }

    /**
     * Operation enregistrerAchat
     */
    public void enregistrerAchat(String pUtilisateur, String pTitre, String pAuteur, String pFournisseur)
    {
        _tie.enregistrerAchat( pUtilisateur,  pTitre,  pAuteur,  pFournisseur);
    }

    /**
     * Operation validerPret
     */
    public void validerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur, String pFournisseur)
    {
        _tie.validerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur,  pFournisseur);
    }

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pFournisseur, String pTitre, String pAuteur)
    {
        _tie.retirerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pFournisseur,  pTitre,  pAuteur);
    }

}
