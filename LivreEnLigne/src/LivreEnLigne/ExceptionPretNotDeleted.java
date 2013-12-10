package LivreEnLigne;

/**
 * Exception definition : ExceptionPretNotDeleted
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionPretNotDeleted extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionPretNotDeleted()
    {
        super(ExceptionPretNotDeletedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionPretNotDeleted(String raison)
    {
        super(ExceptionPretNotDeletedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionPretNotDeleted(String orb_reason, String raison)
    {
        super(ExceptionPretNotDeletedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
