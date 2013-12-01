package LivreEnLigne;

/**
 * Interface definition : Banque
 * 
 * @author OpenORB Compiler
 */
public class BanquePOATie extends BanquePOA
{

    //
    // Private reference to implementation object
    //
    private BanqueOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public BanquePOATie(BanqueOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public BanquePOATie(BanqueOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public BanqueOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(BanqueOperations delegate_)
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
     * Operation verifierCoordonneesBancaires
     */
    public void verifierCoordonneesBancaires(String pCompte, String pCode)
        throws LivreEnLigne.ExceptionMoneyTransferRefused
    {
        _tie.verifierCoordonneesBancaires( pCompte,  pCode);
    }

}
