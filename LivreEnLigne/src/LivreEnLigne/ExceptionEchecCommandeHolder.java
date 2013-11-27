package LivreEnLigne;

/**
 * Holder class for : ExceptionEchecCommande
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionEchecCommandeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionEchecCommande value
     */
    public LivreEnLigne.ExceptionEchecCommande value;

    /**
     * Default constructor
     */
    public ExceptionEchecCommandeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionEchecCommandeHolder(LivreEnLigne.ExceptionEchecCommande initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionEchecCommande from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionEchecCommandeHelper.read(istream);
    }

    /**
     * Write ExceptionEchecCommande into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionEchecCommandeHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionEchecCommande TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionEchecCommandeHelper.type();
    }

}
