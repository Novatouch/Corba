package LivreEnLigne;

/**
 * Holder class for : ExceptionMiseAJourLivre
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionMiseAJourLivreHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionMiseAJourLivre value
     */
    public LivreEnLigne.ExceptionMiseAJourLivre value;

    /**
     * Default constructor
     */
    public ExceptionMiseAJourLivreHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionMiseAJourLivreHolder(LivreEnLigne.ExceptionMiseAJourLivre initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionMiseAJourLivre from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionMiseAJourLivreHelper.read(istream);
    }

    /**
     * Write ExceptionMiseAJourLivre into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionMiseAJourLivreHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionMiseAJourLivre TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionMiseAJourLivreHelper.type();
    }

}
