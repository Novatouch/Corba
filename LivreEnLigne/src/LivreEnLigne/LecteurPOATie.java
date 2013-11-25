package LivreEnLigne;

/**
 * Interface definition : Lecteur
 * 
 * @author OpenORB Compiler
 */
public class LecteurPOATie extends LecteurPOA
{

    //
    // Private reference to implementation object
    //
    private LecteurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public LecteurPOATie(LecteurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public LecteurPOATie(LecteurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public LecteurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(LecteurOperations delegate_)
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
     * Operation miseAjourLivre
     */
    public void miseAjourLivre(String pAuteur, String pTitre, String pFournisseur)
        throws LivreEnLigne.MiseAJourLivreExeption
    {
        _tie.miseAjourLivre( pAuteur,  pTitre,  pFournisseur);
    }

    /**
     * Operation confirmerTelechargement
     */
    public void confirmerTelechargement(String pAuteur, String pTitre, String pFournisseur)
    {
        _tie.confirmerTelechargement( pAuteur,  pTitre,  pFournisseur);
    }

    /**
     * Operation recevoirPret
     */
    public void recevoirPret(String pTitre, String pAuteur, String pContenu, String pCle)
    {
        _tie.recevoirPret( pTitre,  pAuteur,  pContenu,  pCle);
    }

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pTitre, String pAuteur)
    {
        _tie.retirerPret( pTitre,  pAuteur);
    }

}
