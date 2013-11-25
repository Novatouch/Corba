package LivreEnLigne;

/**
 * Holder class for : Banque
 * 
 * @author OpenORB Compiler
 */
final public class BanqueHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Banque value
     */
    public LivreEnLigne.Banque value;

    /**
     * Default constructor
     */
    public BanqueHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public BanqueHolder(LivreEnLigne.Banque initial)
    {
        value = initial;
    }

    /**
     * Read Banque from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = BanqueHelper.read(istream);
    }

    /**
     * Write Banque into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        BanqueHelper.write(ostream,value);
    }

    /**
     * Return the Banque TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return BanqueHelper.type();
    }

}
