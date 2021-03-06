package LivreEnLigne;

/**
 * Interface definition : Lecteur
 * 
 * @author OpenORB Compiler
 */
public class _LecteurStub extends org.omg.CORBA.portable.ObjectImpl
        implements Lecteur
{
    static final String[] _ids_list =
    {
        "IDL:LivreEnLigne/Lecteur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = LivreEnLigne.LecteurOperations.class;

    /**
     * Operation miseAjourLivre
     */
    public void miseAjourLivre(String pTitre, String pAuteur, String pFournisseur, LivreEnLigne.LivreChiffre pLivre)
        throws LivreEnLigne.ExceptionMiseAJourLivre
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("miseAjourLivre",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pFournisseur);
                    LivreEnLigne.LivreChiffreHelper.write(_output,pLivre);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionMiseAJourLivreHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionMiseAJourLivreHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("miseAjourLivre",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.LecteurOperations _self = (LivreEnLigne.LecteurOperations) _so.servant;
                try
                {
                    _self.miseAjourLivre( pTitre,  pAuteur,  pFournisseur,  pLivre);
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
     * Operation miseAjourLivrePret
     */
    public void miseAjourLivrePret(String pTitre, String pAuteur, String pNomProprietaire, String pFournisseur, LivreEnLigne.LivreChiffre pLivre)
        throws LivreEnLigne.ExceptionMiseAJourLivrePret
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("miseAjourLivrePret",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pNomProprietaire);
                    _output.write_string(pFournisseur);
                    LivreEnLigne.LivreChiffreHelper.write(_output,pLivre);
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
                    if (_exception_id.equals(LivreEnLigne.ExceptionMiseAJourLivrePretHelper.id()))
                    {
                        throw LivreEnLigne.ExceptionMiseAJourLivrePretHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("miseAjourLivrePret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.LecteurOperations _self = (LivreEnLigne.LecteurOperations) _so.servant;
                try
                {
                    _self.miseAjourLivrePret( pTitre,  pAuteur,  pNomProprietaire,  pFournisseur,  pLivre);
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
     * Operation confirmerTelechargement
     */
    public void confirmerTelechargement(String pTitre, String pAuteur, String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("confirmerTelechargement",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pFournisseur);
                    LivreEnLigne.FournisseurHelper.write(_output,pIorFournisseur);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("confirmerTelechargement",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.LecteurOperations _self = (LivreEnLigne.LecteurOperations) _so.servant;
                try
                {
                    _self.confirmerTelechargement( pTitre,  pAuteur,  pFournisseur,  pIorFournisseur);
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
     * Operation recevoirPret
     */
    public void recevoirPret(String pTitre, String pAuteur, String pNomProprietaire, String pFournisseur, LivreEnLigne.Fournisseur pIorFournisseur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recevoirPret",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pNomProprietaire);
                    _output.write_string(pFournisseur);
                    LivreEnLigne.FournisseurHelper.write(_output,pIorFournisseur);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recevoirPret",_opsClass);
                if (_so == null)
                   continue;
                LivreEnLigne.LecteurOperations _self = (LivreEnLigne.LecteurOperations) _so.servant;
                try
                {
                    _self.recevoirPret( pTitre,  pAuteur,  pNomProprietaire,  pFournisseur,  pIorFournisseur);
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
    public void retirerPret(String pTitre, String pAuteur, String pNomProprietaire)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("retirerPret",true);
                    _output.write_string(pTitre);
                    _output.write_string(pAuteur);
                    _output.write_string(pNomProprietaire);
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
                LivreEnLigne.LecteurOperations _self = (LivreEnLigne.LecteurOperations) _so.servant;
                try
                {
                    _self.retirerPret( pTitre,  pAuteur,  pNomProprietaire);
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
