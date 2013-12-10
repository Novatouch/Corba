package LivreEnLigne;

/**
 * Holder class for : ExceptionPretNotDeleted
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionPretNotDeletedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionPretNotDeleted value
     */
    public LivreEnLigne.ExceptionPretNotDeleted value;

    /**
     * Default constructor
     */
    public ExceptionPretNotDeletedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionPretNotDeletedHolder(LivreEnLigne.ExceptionPretNotDeleted initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionPretNotDeleted from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionPretNotDeletedHelper.read(istream);
    }

    /**
     * Write ExceptionPretNotDeleted into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionPretNotDeletedHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionPretNotDeleted TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionPretNotDeletedHelper.type();
    }

}
