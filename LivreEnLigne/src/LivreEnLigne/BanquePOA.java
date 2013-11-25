package LivreEnLigne;

/**
 * Interface definition : Banque
 * 
 * @author OpenORB Compiler
 */
public abstract class BanquePOA extends org.omg.PortableServer.Servant
        implements BanqueOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Banque _this()
    {
        return BanqueHelper.narrow(_this_object());
    }

    public Banque _this(org.omg.CORBA.ORB orb)
    {
        return BanqueHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:LivreEnLigne/Banque:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("verifierCoordonneesBancaires")) {
                return _invoke_verifierCoordonneesBancaires(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_verifierCoordonneesBancaires(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_ulong();
        int arg1_in = _is.read_ulong();

        try
        {
            verifierCoordonneesBancaires(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (LivreEnLigne.MoneyTransferRefused _exception)
        {
            _output = handler.createExceptionReply();
            LivreEnLigne.MoneyTransferRefusedHelper.write(_output,_exception);
        }
        return _output;
    }

}
