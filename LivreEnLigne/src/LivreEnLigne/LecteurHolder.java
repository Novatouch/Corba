package LivreEnLigne;

/**
 * Holder class for : Lecteur
 * 
 * @author OpenORB Compiler
 */
final public class LecteurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Lecteur value
     */
    public LivreEnLigne.Lecteur value;

    /**
     * Default constructor
     */
    public LecteurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LecteurHolder(LivreEnLigne.Lecteur initial)
    {
        value = initial;
    }

    /**
     * Read Lecteur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LecteurHelper.read(istream);
    }

    /**
     * Write Lecteur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LecteurHelper.write(ostream,value);
    }

    /**
     * Return the Lecteur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LecteurHelper.type();
    }

}
