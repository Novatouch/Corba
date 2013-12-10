package LivreEnLigne;

/**
 * Holder class for : ExceptionPretNotSaved
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionPretNotSavedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionPretNotSaved value
     */
    public LivreEnLigne.ExceptionPretNotSaved value;

    /**
     * Default constructor
     */
    public ExceptionPretNotSavedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionPretNotSavedHolder(LivreEnLigne.ExceptionPretNotSaved initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionPretNotSaved from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionPretNotSavedHelper.read(istream);
    }

    /**
     * Write ExceptionPretNotSaved into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionPretNotSavedHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionPretNotSaved TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionPretNotSavedHelper.type();
    }

}
