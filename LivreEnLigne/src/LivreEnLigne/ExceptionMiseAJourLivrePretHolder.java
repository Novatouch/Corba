package LivreEnLigne;

/**
 * Holder class for : ExceptionMiseAJourLivrePret
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionMiseAJourLivrePretHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionMiseAJourLivrePret value
     */
    public LivreEnLigne.ExceptionMiseAJourLivrePret value;

    /**
     * Default constructor
     */
    public ExceptionMiseAJourLivrePretHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionMiseAJourLivrePretHolder(LivreEnLigne.ExceptionMiseAJourLivrePret initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionMiseAJourLivrePret from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionMiseAJourLivrePretHelper.read(istream);
    }

    /**
     * Write ExceptionMiseAJourLivrePret into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionMiseAJourLivrePretHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionMiseAJourLivrePret TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionMiseAJourLivrePretHelper.type();
    }

}
