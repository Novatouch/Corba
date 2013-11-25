package LivreEnLigne;

/**
 * Holder class for : EchecCommande
 * 
 * @author OpenORB Compiler
 */
final public class EchecCommandeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EchecCommande value
     */
    public LivreEnLigne.EchecCommande value;

    /**
     * Default constructor
     */
    public EchecCommandeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EchecCommandeHolder(LivreEnLigne.EchecCommande initial)
    {
        value = initial;
    }

    /**
     * Read EchecCommande from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EchecCommandeHelper.read(istream);
    }

    /**
     * Write EchecCommande into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EchecCommandeHelper.write(ostream,value);
    }

    /**
     * Return the EchecCommande TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EchecCommandeHelper.type();
    }

}
