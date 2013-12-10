package LivreEnLigne;

/**
 * Exception definition : ExceptionPretNotAllowed
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionPretNotAllowed extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionPretNotAllowed()
    {
        super(ExceptionPretNotAllowedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionPretNotAllowed(String raison)
    {
        super(ExceptionPretNotAllowedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionPretNotAllowed(String orb_reason, String raison)
    {
        super(ExceptionPretNotAllowedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
