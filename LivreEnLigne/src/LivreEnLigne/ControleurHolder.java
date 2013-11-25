package LivreEnLigne;

/**
 * Holder class for : Controleur
 * 
 * @author OpenORB Compiler
 */
final public class ControleurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Controleur value
     */
    public LivreEnLigne.Controleur value;

    /**
     * Default constructor
     */
    public ControleurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ControleurHolder(LivreEnLigne.Controleur initial)
    {
        value = initial;
    }

    /**
     * Read Controleur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ControleurHelper.read(istream);
    }

    /**
     * Write Controleur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ControleurHelper.write(ostream,value);
    }

    /**
     * Return the Controleur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ControleurHelper.type();
    }

}
