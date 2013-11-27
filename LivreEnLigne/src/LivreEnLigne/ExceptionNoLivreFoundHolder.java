package LivreEnLigne;

/**
 * Holder class for : ExceptionNoLivreFound
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionNoLivreFoundHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionNoLivreFound value
     */
    public LivreEnLigne.ExceptionNoLivreFound value;

    /**
     * Default constructor
     */
    public ExceptionNoLivreFoundHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionNoLivreFoundHolder(LivreEnLigne.ExceptionNoLivreFound initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionNoLivreFound from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionNoLivreFoundHelper.read(istream);
    }

    /**
     * Write ExceptionNoLivreFound into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionNoLivreFoundHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionNoLivreFound TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionNoLivreFoundHelper.type();
    }

}
