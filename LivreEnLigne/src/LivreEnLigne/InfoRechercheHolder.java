package LivreEnLigne;

/**
 * Holder class for : InfoRecherche
 * 
 * @author OpenORB Compiler
 */
final public class InfoRechercheHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoRecherche value
     */
    public LivreEnLigne.InfoRecherche value;

    /**
     * Default constructor
     */
    public InfoRechercheHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoRechercheHolder(LivreEnLigne.InfoRecherche initial)
    {
        value = initial;
    }

    /**
     * Read InfoRecherche from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoRechercheHelper.read(istream);
    }

    /**
     * Write InfoRecherche into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoRechercheHelper.write(ostream,value);
    }

    /**
     * Return the InfoRecherche TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoRechercheHelper.type();
    }

}
