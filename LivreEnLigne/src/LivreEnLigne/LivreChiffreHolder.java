package LivreEnLigne;

/**
 * Holder class for : LivreChiffre
 * 
 * @author OpenORB Compiler
 */
final public class LivreChiffreHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LivreChiffre value
     */
    public LivreEnLigne.LivreChiffre value;

    /**
     * Default constructor
     */
    public LivreChiffreHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LivreChiffreHolder(LivreEnLigne.LivreChiffre initial)
    {
        value = initial;
    }

    /**
     * Read LivreChiffre from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LivreChiffreHelper.read(istream);
    }

    /**
     * Write LivreChiffre into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LivreChiffreHelper.write(ostream,value);
    }

    /**
     * Return the LivreChiffre TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LivreChiffreHelper.type();
    }

}
