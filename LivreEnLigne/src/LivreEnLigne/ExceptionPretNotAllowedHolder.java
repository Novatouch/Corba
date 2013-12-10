package LivreEnLigne;

/**
 * Holder class for : ExceptionPretNotAllowed
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionPretNotAllowedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionPretNotAllowed value
     */
    public LivreEnLigne.ExceptionPretNotAllowed value;

    /**
     * Default constructor
     */
    public ExceptionPretNotAllowedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionPretNotAllowedHolder(LivreEnLigne.ExceptionPretNotAllowed initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionPretNotAllowed from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionPretNotAllowedHelper.read(istream);
    }

    /**
     * Write ExceptionPretNotAllowed into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionPretNotAllowedHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionPretNotAllowed TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionPretNotAllowedHelper.type();
    }

}
