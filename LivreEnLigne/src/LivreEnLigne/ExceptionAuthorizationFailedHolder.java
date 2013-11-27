package LivreEnLigne;

/**
 * Holder class for : ExceptionAuthorizationFailed
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionAuthorizationFailedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionAuthorizationFailed value
     */
    public LivreEnLigne.ExceptionAuthorizationFailed value;

    /**
     * Default constructor
     */
    public ExceptionAuthorizationFailedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionAuthorizationFailedHolder(LivreEnLigne.ExceptionAuthorizationFailed initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionAuthorizationFailed from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionAuthorizationFailedHelper.read(istream);
    }

    /**
     * Write ExceptionAuthorizationFailed into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionAuthorizationFailedHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionAuthorizationFailed TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionAuthorizationFailedHelper.type();
    }

}
