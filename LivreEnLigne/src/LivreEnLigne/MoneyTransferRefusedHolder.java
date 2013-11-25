package LivreEnLigne;

/**
 * Holder class for : MoneyTransferRefused
 * 
 * @author OpenORB Compiler
 */
final public class MoneyTransferRefusedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal MoneyTransferRefused value
     */
    public LivreEnLigne.MoneyTransferRefused value;

    /**
     * Default constructor
     */
    public MoneyTransferRefusedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MoneyTransferRefusedHolder(LivreEnLigne.MoneyTransferRefused initial)
    {
        value = initial;
    }

    /**
     * Read MoneyTransferRefused from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MoneyTransferRefusedHelper.read(istream);
    }

    /**
     * Write MoneyTransferRefused into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MoneyTransferRefusedHelper.write(ostream,value);
    }

    /**
     * Return the MoneyTransferRefused TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MoneyTransferRefusedHelper.type();
    }

}
