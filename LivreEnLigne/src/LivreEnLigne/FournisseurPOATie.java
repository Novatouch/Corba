package LivreEnLigne;

/**
 * Interface definition : Fournisseur
 * 
 * @author OpenORB Compiler
 */
public class FournisseurPOATie extends FournisseurPOA
{

    //
    // Private reference to implementation object
    //
    private FournisseurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public FournisseurPOATie(FournisseurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public FournisseurPOATie(FournisseurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public FournisseurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(FournisseurOperations delegate_)
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
     * Operation rechercherLivre
     */
    public float rechercherLivre(String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionNoLivreFound
    {
        return _tie.rechercherLivre( pTitre,  pAuteur);
    }

    /**
     * Operation commander
     */
    public void commander(String pTitre, String pAuteur, String pCompte, String pCode, String pLecteur, LivreEnLigne.Lecteur pIorLecteur)
        throws LivreEnLigne.ExceptionEchecCommande
    {
        _tie.commander( pTitre,  pAuteur,  pCompte,  pCode,  pLecteur,  pIorLecteur);
    }

    /**
     * Operation telechargerLivre
     */
    public LivreEnLigne.LivreChiffre telechargerLivre(String pTitre, String pAuteur, String pUtilisateur)
    {
        return _tie.telechargerLivre( pTitre,  pAuteur,  pUtilisateur);
    }

    /**
     * Operation creerPret
     */
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur)
    {
        _tie.creerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur);
    }

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur)
    {
        _tie.retirerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur);
    }

}
