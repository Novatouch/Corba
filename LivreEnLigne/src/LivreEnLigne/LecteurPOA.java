package LivreEnLigne;

/**
 * Interface definition : Lecteur
 * 
 * @author OpenORB Compiler
 */
public abstract class LecteurPOA extends org.omg.PortableServer.Servant
        implements LecteurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Lecteur _this()
    {
        return LecteurHelper.narrow(_this_object());
    }

    public Lecteur _this(org.omg.CORBA.ORB orb)
    {
        return LecteurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:LivreEnLigne/Lecteur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("confirmerTelechargement")) {
                return _invoke_confirmerTelechargement(_is, handler);
        } else if (opName.equals("miseAjourLivre")) {
                return _invoke_miseAjourLivre(_is, handler);
        } else if (opName.equals("recevoirPret")) {
                return _invoke_recevoirPret(_is, handler);
        } else if (opName.equals("retirerPret")) {
                return _invoke_retirerPret(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_miseAjourLivre(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            miseAjourLivre(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (LivreEnLigne.MiseAJourLivreExeption _exception)
        {
            _output = handler.createExceptionReply();
            LivreEnLigne.MiseAJourLivreExeptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_confirmerTelechargement(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        confirmerTelechargement(arg0_in, arg1_in, arg2_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recevoirPret(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();

        recevoirPret(arg0_in, arg1_in, arg2_in, arg3_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_retirerPret(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        retirerPret(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

}
