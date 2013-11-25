package LivreEnLigne;

/**
 * Exception definition : MoneyTransferRefused
 * 
 * @author OpenORB Compiler
 */
public final class MoneyTransferRefused extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public MoneyTransferRefused()
    {
        super(MoneyTransferRefusedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public MoneyTransferRefused(String raison)
    {
        super(MoneyTransferRefusedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public MoneyTransferRefused(String orb_reason, String raison)
    {
        super(MoneyTransferRefusedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
