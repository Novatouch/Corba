package LivreEnLigne;

/**
 * Interface definition : Controleur
 * 
 * @author OpenORB Compiler
 */
public class _ControleurStub extends org.omg.CORBA.portable.ObjectImpl
        implements Controleur
{
    static final String[] _ids_list =
    {
        "IDL:LivreEnLigne/Controleur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = LivreEnLigne.ControleurOperations.class;

    /**
     * Operation verifierAutorisation
     */
    public void verifierAutorisation(String pTitre, String pAuteur, String pUtilisateur, String pFournisseur)
        throws LivreEnLigne.ExceptionAuthorizationFailed
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAutorisation",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pUtilisateur);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionAuthorizationFailedHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionAuthorizationFailedHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAutorisation",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.ControleurOperations _self = (LivreEnLigne.ControleurOperations) _so.servant;
                try
                {
                    _self.verifierAutorisation( pTitre,  pAuteur,  pUtilisateur,  pFournisseur);
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
     * Operation verifierAutorisationPret
     */
    public void verifierAutorisationPret(String pTitre, String pAuteur, String pUtilisateurProprietaire, String pUtilisateurEmprunteur, String pFournisseur)
        throws LivreEnLigne.ExceptionAuthorizationFailed
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAutorisationPret",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pUtilisateurProprietaire);
                    _output.write_string(pUtilisateurEmprunteur);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionAuthorizationFailedHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionAuthorizationFailedHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAutorisationPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.ControleurOperations _self = (LivreEnLigne.ControleurOperations) _so.servant;
                try
                {
                    _self.verifierAutorisationPret( pTitre,  pAuteur,  pUtilisateurProprietaire,  pUtilisateurEmprunteur,  pFournisseur);
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
     * Operation enregistrerPret
     */
    public void enregistrerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pTitre, String pAuteur, String pFournisseur)
        throws LivreEnLigne.ExceptionPretNotSaved
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerPret",true);
                    _output.write_string(pUtilisateurPreteur);
                    _output.write_string(pUtilisateurEmprunteur);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionPretNotSavedHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionPretNotSavedHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.ControleurOperations _self = (LivreEnLigne.ControleurOperations) _so.servant;
                try
                {
                    _self.enregistrerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pTitre,  pAuteur,  pFournisseur);
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
     * Operation enregistrerAchat
     */
    public void enregistrerAchat(String pUtilisateur, String pTitre, String pAuteur, String pFournisseur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerAchat",true);
                    _output.write_string(pUtilisateur);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerAchat",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.ControleurOperations _self = (LivreEnLigne.ControleurOperations) _so.servant;
                try
                {
                    _self.enregistrerAchat( pUtilisateur,  pTitre,  pAuteur,  pFournisseur);
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
    public void retirerPret(String pUtilisateurPreteur, String pUtilisateurEmprunteur, String pFournisseur, String pTitre, String pAuteur)
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
                    _output.write_string(pFournisseur);
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
                LivreEnLigne.ControleurOperations _self = (LivreEnLigne.ControleurOperations) _so.servant;
                try
                {
                    _self.retirerPret( pUtilisateurPreteur,  pUtilisateurEmprunteur,  pFournisseur,  pTitre,  pAuteur);
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
                LivreEnLigne.ControleurOperations _self = (LivreEnLigne.ControleurOperations) _so.servant;
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
