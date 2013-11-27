package LivreEnLigne;

/**
 * Exception definition : ExceptionMoneyTransferRefused
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionMoneyTransferRefused extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionMoneyTransferRefused()
    {
        super(ExceptionMoneyTransferRefusedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionMoneyTransferRefused(String raison)
    {
        super(ExceptionMoneyTransferRefusedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionMoneyTransferRefused(String orb_reason, String raison)
    {
        super(ExceptionMoneyTransferRefusedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
