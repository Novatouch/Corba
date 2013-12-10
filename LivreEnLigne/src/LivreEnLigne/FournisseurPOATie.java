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
    public LivreEnLigne.LivreChiffre telechargerLivre(String pTitre, String pAuteur, String pUtilisateurProprietaire)
    {
        return _tie.telechargerLivre( pTitre,  pAuteur,  pUtilisateurProprietaire);
    }

    /**
     * Operation telechargerLivrePret
     */
    public LivreEnLigne.LivreChiffre telechargerLivrePret(String pTitre, String pAuteur, String pUtilisateur, String pUtilisateurEmprunteur)
    {
        return _tie.telechargerLivrePret( pTitre,  pAuteur,  pUtilisateur,  pUtilisateurEmprunteur);
    }

    /**
     * Operation creerPret
     */
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, LivreEnLigne.Lecteur pIorUtilisateurEmprunteur, String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionPretNotAllowed
    {
        _tie.creerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pIorUtilisateurEmprunteur,  pTitre,  pAuteur);
    }

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, LivreEnLigne.Lecteur pIorUtilisateurEmprunteur, String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionPretNotDeleted
    {
        _tie.retirerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pIorUtilisateurEmprunteur,  pTitre,  pAuteur);
    }

    /**
     * Operation flush
     */
    public void flush()
    {
        _tie.flush();
    }

}
