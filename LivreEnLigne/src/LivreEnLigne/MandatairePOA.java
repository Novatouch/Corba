package LivreEnLigne;

/**
 * Interface definition : Mandataire
 * 
 * @author OpenORB Compiler
 */
public abstract class MandatairePOA extends org.omg.PortableServer.Servant
        implements MandataireOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Mandataire _this()
    {
        return MandataireHelper.narrow(_this_object());
    }

    public Mandataire _this(org.omg.CORBA.ORB orb)
    {
        return MandataireHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:LivreEnLigne/Mandataire:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("enregistrementFournisseur")) {
                return _invoke_enregistrementFournisseur(_is, handler);
        } else if (opName.equals("flush")) {
                return _invoke_flush(_is, handler);
        } else if (opName.equals("rechercherLivre")) {
                return _invoke_rechercherLivre(_is, handler);
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
            LivreEnLigne.InfoRecherche _arg_result = rechercherLivre(arg0_in, arg1_in);

            _output = handler.createReply();
            LivreEnLigne.InfoRechercheHelper.write(_output,_arg_result);

        }
        catch (LivreEnLigne.ExceptionNoLivreFound _exception)
        {
            _output = handler.createExceptionReply();
            LivreEnLigne.ExceptionNoLivreFoundHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrementFournisseur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        LivreEnLigne.Fournisseur arg1_in = LivreEnLigne.FournisseurHelper.read(_is);

        enregistrementFournisseur(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_flush(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        flush();

        _output = handler.createReply();

        return _output;
    }

}
