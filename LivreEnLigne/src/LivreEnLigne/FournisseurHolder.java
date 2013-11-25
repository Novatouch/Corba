package LivreEnLigne;

/**
 * Holder class for : Fournisseur
 * 
 * @author OpenORB Compiler
 */
final public class FournisseurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Fournisseur value
     */
    public LivreEnLigne.Fournisseur value;

    /**
     * Default constructor
     */
    public FournisseurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public FournisseurHolder(LivreEnLigne.Fournisseur initial)
    {
        value = initial;
    }

    /**
     * Read Fournisseur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = FournisseurHelper.read(istream);
    }

    /**
     * Write Fournisseur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        FournisseurHelper.write(ostream,value);
    }

    /**
     * Return the Fournisseur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return FournisseurHelper.type();
    }

}
