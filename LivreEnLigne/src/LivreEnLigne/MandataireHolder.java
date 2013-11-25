package LivreEnLigne;

/**
 * Holder class for : Mandataire
 * 
 * @author OpenORB Compiler
 */
final public class MandataireHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Mandataire value
     */
    public LivreEnLigne.Mandataire value;

    /**
     * Default constructor
     */
    public MandataireHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MandataireHolder(LivreEnLigne.Mandataire initial)
    {
        value = initial;
    }

    /**
     * Read Mandataire from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MandataireHelper.read(istream);
    }

    /**
     * Write Mandataire into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MandataireHelper.write(ostream,value);
    }

    /**
     * Return the Mandataire TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MandataireHelper.type();
    }

}
