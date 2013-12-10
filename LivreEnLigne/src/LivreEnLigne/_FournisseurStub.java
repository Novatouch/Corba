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
        throws LivreEnLigne.ExceptionNoLivreFound
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionNoLivreFoundHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionNoLivreFoundHelper.read(_exception.getInputStream());
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
    public void commander(String pTitre, String pAuteur, String pCompte, String pCode, String pLecteur, LivreEnLigne.Lecteur pIorLecteur)
        throws LivreEnLigne.ExceptionEchecCommande
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
                    _output.write_string(pCompte);
                    _output.write_string(pCode);
                    _output.write_string(pLecteur);
                    LivreEnLigne.LecteurHelper.write(_output,pIorLecteur);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionEchecCommandeHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionEchecCommandeHelper.read(_exception.getInputStream());
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
                    _self.commander( pTitre,  pAuteur,  pCompte,  pCode,  pLecteur,  pIorLecteur);
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
    public LivreEnLigne.LivreChiffre telechargerLivre(String pTitre, String pAuteur, String pUtilisateurProprietaire)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("telechargerLivre",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pUtilisateurProprietaire);
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
                    return _self.telechargerLivre( pTitre,  pAuteur,  pUtilisateurProprietaire);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation telechargerLivrePret
     */
    public LivreEnLigne.LivreChiffre telechargerLivrePret(String pTitre, String pAuteur, String pUtilisateur, String pUtilisateurEmprunteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("telechargerLivrePret",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pUtilisateur);
                    _output.write_string(pUtilisateurEmprunteur);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("telechargerLivrePret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    return _self.telechargerLivrePret( pTitre,  pAuteur,  pUtilisateur,  pUtilisateurEmprunteur);
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
    public void creerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, LivreEnLigne.Lecteur pIorUtilisateurEmprunteur, String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionPretNotAllowed
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
                    LivreEnLigne.LecteurHelper.write(_output,pIorUtilisateurEmprunteur);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionPretNotAllowedHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionPretNotAllowedHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    _self.creerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pIorUtilisateurEmprunteur,  pTitre,  pAuteur);
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
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, LivreEnLigne.Lecteur pIorUtilisateurEmprunteur, String pTitre, String pAuteur)
        throws LivreEnLigne.ExceptionPretNotDeleted
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
                    LivreEnLigne.LecteurHelper.write(_output,pIorUtilisateurEmprunteur);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionPretNotDeletedHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionPretNotDeletedHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("retirerPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    _self.retirerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pIorUtilisateurEmprunteur,  pTitre,  pAuteur);
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
     * Operation flush
     */
    public void flush()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("flush",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("flush",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.FournisseurOperations _self = (LivreEnLigne.FournisseurOperations) _so.servant;
                try
                {
                    _self.flush();
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
