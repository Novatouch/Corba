package LivreEnLigne;

/**
 * Holder class for : AuthorizationFailed
 * 
 * @author OpenORB Compiler
 */
final public class AuthorizationFailedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AuthorizationFailed value
     */
    public LivreEnLigne.AuthorizationFailed value;

    /**
     * Default constructor
     */
    public AuthorizationFailedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AuthorizationFailedHolder(LivreEnLigne.AuthorizationFailed initial)
    {
        value = initial;
    }

    /**
     * Read AuthorizationFailed from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AuthorizationFailedHelper.read(istream);
    }

    /**
     * Write AuthorizationFailed into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AuthorizationFailedHelper.write(ostream,value);
    }

    /**
     * Return the AuthorizationFailed TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AuthorizationFailedHelper.type();
    }

}
