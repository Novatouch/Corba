package LivreEnLigne;

/**
 * Interface definition : Fournisseur
 * 
 * @author OpenORB Compiler
 */
public class _FournisseurStub extends org.omg.CORBA.portable.ObjectImpl
        implements Fournisseur
{
    static final String[] _ids_list =
    {
        "IDL:LivreEnLigne/Fournisseur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = LivreEnLigne.FournisseurOperations.class;

    /**
     * Operation rechercherLivre
     */
    public float rechercherLivre(String pTitre, String pAuteur)
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
                    float _arg_ret = _input.read_float();
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
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
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
     * Operation commander
     */
    public void commander(String pTitre, String pAuteur, LivreEnLigne.InfoBancaires pInfo, String pUtilisateur)
        throws LivreEnLigne.EchecCommande
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("commander",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    LivreEnLigne.InfoBancairesHelper.write(_output,pInfo);
                    _output.write_string(pUtilisateur);
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
                    if (_exception_id.equals(LivreEnLigne.EchecCommandeHelper.id()))
                    {
                        throw LivreEnLigne.EchecCommandeHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("commander",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    _self.commander( pTitre,  pAuteur,  pInfo,  pUtilisateur);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation telechargerLivre
     */
    public LivreEnLigne.LivreChiffre telechargerLivre(String pUtilisateur, String pTitre, String pAuteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("telechargerLivre",true);
                    _output.write_string(pUtilisateur);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _input = this._invoke(_output);
                    LivreEnLigne.LivreChiffre _arg_ret = LivreEnLigne.LivreChiffreHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("telechargerLivre",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    return _self.telechargerLivre( pUtilisateur,  pTitre,  pAuteur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerPret
     */
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerPret",true);
                    _output.write_string(pUtilisateurPreteur);
                    _output.write_string(pUtilisateurEmprunteur);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    _self.creerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation retirerPret
     */
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("retirerPret",true);
                    _output.write_string(pUtilisateurPreteur);
                    _output.write_string(pUtilisateurEmprunteur);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("retirerPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    _self.retirerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur);
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
