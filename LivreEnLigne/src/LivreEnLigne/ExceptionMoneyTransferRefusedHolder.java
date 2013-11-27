package LivreEnLigne;

/**
 * Holder class for : ExceptionMoneyTransferRefused
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionMoneyTransferRefusedHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionMoneyTransferRefused value
     */
    public LivreEnLigne.ExceptionMoneyTransferRefused value;

    /**
     * Default constructor
     */
    public ExceptionMoneyTransferRefusedHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionMoneyTransferRefusedHolder(LivreEnLigne.ExceptionMoneyTransferRefused initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionMoneyTransferRefused from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionMoneyTransferRefusedHelper.read(istream);
    }

    /**
     * Write ExceptionMoneyTransferRefused into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionMoneyTransferRefusedHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionMoneyTransferRefused TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionMoneyTransferRefusedHelper.type();
    }

}
