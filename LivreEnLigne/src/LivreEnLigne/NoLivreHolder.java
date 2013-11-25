package LivreEnLigne;

/**
 * Holder class for : NoLivre
 * 
 * @author OpenORB Compiler
 */
final public class NoLivreHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal NoLivre value
     */
    public LivreEnLigne.NoLivre value;

    /**
     * Default constructor
     */
    public NoLivreHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NoLivreHolder(LivreEnLigne.NoLivre initial)
    {
        value = initial;
    }

    /**
     * Read NoLivre from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NoLivreHelper.read(istream);
    }

    /**
     * Write NoLivre into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NoLivreHelper.write(ostream,value);
    }

    /**
     * Return the NoLivre TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NoLivreHelper.type();
    }

}
