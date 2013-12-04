package LivreEnLigne;

/**
 * Interface definition : Controleur
 * 
 * @author OpenORB Compiler
 */
public abstract class ControleurPOA extends org.omg.PortableServer.Servant
        implements ControleurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Controleur _this()
    {
        return ControleurHelper.narrow(_this_object());
    }

    public Controleur _this(org.omg.CORBA.ORB orb)
    {
        return ControleurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:LivreEnLigne/Controleur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("enregistrerAchat")) {
                return _invoke_enregistrerAchat(_is, handler);
        } else if (opName.equals("enregistrerPret")) {
                return _invoke_enregistrerPret(_is, handler);
        } else if (opName.equals("retirerPret")) {
                return _invoke_retirerPret(_is, handler);
        } else if (opName.equals("validerPret")) {
                return _invoke_validerPret(_is, handler);
        } else if (opName.equals("verifierAutorisation")) {
                return _invoke_verifierAutorisation(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_verifierAutorisation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();

        try
        {
            verifierAutorisation(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (LivreEnLigne.ExceptionAuthorizationFailed _exception)
        {
            _output = handler.createExceptionReply();
            LivreEnLigne.ExceptionAuthorizationFailedHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerPret(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();

        enregistrerPret(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerAchat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();

        enregistrerAchat(arg0_in, arg1_in, arg2_in, arg3_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_validerPret(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();

        validerPret(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_retirerPret(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();

        retirerPret(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

        _output = handler.createReply();

        return _output;
    }

}
