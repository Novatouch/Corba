package LivreEnLigne;

/**
 * Interface definition : Mandataire
 * 
 * @author OpenORB Compiler
 */
public class _MandataireStub extends org.omg.CORBA.portable.ObjectImpl
        implements Mandataire
{
    static final String[] _ids_list =
    {
        "IDL:LivreEnLigne/Mandataire:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = LivreEnLigne.MandataireOperations.class;

    /**
     * Operation rechercherLivre
     */
    public LivreEnLigne.InfoRecherche rechercherLivre(String pTitre, String pAuteur)
        throws LivreEnLigne.NoLivre
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherLivre",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _input = this._invoke(_output);
                    LivreEnLigne.InfoRecherche _arg_ret = LivreEnLigne.InfoRechercheHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(LivreEnLigne.NoLivreHelper.id()))
                    {
                        throw LivreEnLigne.NoLivreHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherLivre",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.MandataireOperations _self = (LivreEnLigne.MandataireOperations) _so.servant;
                try
                {
                    return _self.rechercherLivre( pTitre,  pAuteur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrementFournisseur
     */
    public void enregistrementFournisseur(String pFournisseur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrementFournisseur",true);
                    _output.write_string(pFournisseur);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrementFournisseur",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.MandataireOperations _self = (LivreEnLigne.MandataireOperations) _so.servant;
                try
                {
                    _self.enregistrementFournisseur( pFournisseur);
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
