package LivreEnLigne;

/**
 * Interface definition : Mandataire
 * 
 * @author OpenORB Compiler
 */
public class MandatairePOATie extends MandatairePOA
{

    //
    // Private reference to implementation object
    //
    private MandataireOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public MandatairePOATie(MandataireOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public MandatairePOATie(MandataireOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public MandataireOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(MandataireOperations delegate_)
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
    public LivreEnLigne.InfoRecherche rechercherLivre(String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionNoLivreFound
    {
        return _tie.rechercherLivre( pTitre,  pAuteur);
    }

    /**
     * Operation enregistrementFournisseur
     */
    public void enregistrementFournisseur(String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur)
    {
        _tie.enregistrementFournisseur( pFournisseur,  pIorFournisseur);
    }

    /**
     * Operation flush
     */
    public void flush()
    {
        _tie.flush();
    }

}
