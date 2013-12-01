package LivreEnLigne;

/**
 * Interface definition : Fournisseur
 * 
 * @author OpenORB Compiler
 */
public abstract class FournisseurPOA extends org.omg.PortableServer.Servant
        implements FournisseurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Fournisseur _this()
    {
        return FournisseurHelper.narrow(_this_object());
    }

    public Fournisseur _this(org.omg.CORBA.ORB orb)
    {
        return FournisseurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:LivreEnLigne/Fournisseur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("commander")) {
                return _invoke_commander(_is, handler);
        } else if (opName.equals("creerPret")) {
                return _invoke_creerPret(_is, handler);
        } else if (opName.equals("rechercherLivre")) {
                return _invoke_rechercherLivre(_is, handler);
        } else if (opName.equals("retirerPret")) {
                return _invoke_retirerPret(_is, handler);
        } else if (opName.equals("telechargerLivre")) {
                return _invoke_telechargerLivre(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_rechercherLivre(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            float _arg_result = rechercherLivre(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_float(_arg_result);

        }
        catch (LivreEnLigne.ExceptionNoLivreFound _exception)
        {
            _output = handler.createExceptionReply();
            LivreEnLigne.ExceptionNoLivreFoundHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_commander(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        String arg4_in = _is.read_string();
        LivreEnLigne.Lecteur arg5_in = LivreEnLigne.LecteurHelper.read(_is);

        try
        {
            commander(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in, arg5_in);

            _output = handler.createReply();

        }
        catch (LivreEnLigne.ExceptionEchecCommande _exception)
        {
            _output = handler.createExceptionReply();
            LivreEnLigne.ExceptionEchecCommandeHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_telechargerLivre(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        LivreEnLigne.Lecteur arg1_in = LivreEnLigne.LecteurHelper.read(_is);
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();

        LivreEnLigne.LivreChiffre _arg_result = telechargerLivre(arg0_in, arg1_in, arg2_in, arg3_in);

        _output = handler.createReply();
        LivreEnLigne.LivreChiffreHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerPret(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();

        creerPret(arg0_in, arg1_in, arg2_in, arg3_in);

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

        retirerPret(arg0_in, arg1_in, arg2_in, arg3_in);

        _output = handler.createReply();

        return _output;
    }

}
