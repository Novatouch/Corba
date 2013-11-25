package LivreEnLigne;

/**
 * Holder class for : InfoBancaires
 * 
 * @author OpenORB Compiler
 */
final public class InfoBancairesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoBancaires value
     */
    public LivreEnLigne.InfoBancaires value;

    /**
     * Default constructor
     */
    public InfoBancairesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoBancairesHolder(LivreEnLigne.InfoBancaires initial)
    {
        value = initial;
    }

    /**
     * Read InfoBancaires from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoBancairesHelper.read(istream);
    }

    /**
     * Write InfoBancaires into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoBancairesHelper.write(ostream,value);
    }

    /**
     * Return the InfoBancaires TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoBancairesHelper.type();
    }

}
