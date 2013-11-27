package LivreEnLigne;

/**
 * Interface definition : Banque
 * 
 * @author OpenORB Compiler
 */
public class _BanqueStub extends org.omg.CORBA.portable.ObjectImpl
        implements Banque
{
    static final String[] _ids_list =
    {
        "IDL:LivreEnLigne/Banque:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = LivreEnLigne.BanqueOperations.class;

    /**
     * Operation verifierCoordonneesBancaires
     */
    public void verifierCoordonneesBancaires(int pCompte, int pCode)
        throws LivreEnLigne.ExceptionMoneyTransferRefused
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierCoordonneesBancaires",true);
                    _output.write_ulong(pCompte);
                    _output.write_ulong(pCode);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(LivreEnLigne.ExceptionMoneyTransferRefusedHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionMoneyTransferRefusedHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierCoordonneesBancaires",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.BanqueOperations _self = (LivreEnLigne.BanqueOperations) _so.servant;
                try
                {
                    _self.verifierCoordonneesBancaires( pCompte,  pCode);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
