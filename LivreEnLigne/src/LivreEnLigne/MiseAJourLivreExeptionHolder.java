package LivreEnLigne;

/**
 * Holder class for : MiseAJourLivreExeption
 * 
 * @author OpenORB Compiler
 */
final public class MiseAJourLivreExeptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal MiseAJourLivreExeption value
     */
    public LivreEnLigne.MiseAJourLivreExeption value;

    /**
     * Default constructor
     */
    public MiseAJourLivreExeptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MiseAJourLivreExeptionHolder(LivreEnLigne.MiseAJourLivreExeption initial)
    {
        value = initial;
    }

    /**
     * Read MiseAJourLivreExeption from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MiseAJourLivreExeptionHelper.read(istream);
    }

    /**
     * Write MiseAJourLivreExeption into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MiseAJourLivreExeptionHelper.write(ostream,value);
    }

    /**
     * Return the MiseAJourLivreExeption TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MiseAJourLivreExeptionHelper.type();
    }

}
