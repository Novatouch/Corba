package LivreEnLigne;

/**
 * Exception definition : ExceptionAuthorizationFailed
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionAuthorizationFailed extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionAuthorizationFailed()
    {
        super(ExceptionAuthorizationFailedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionAuthorizationFailed(String raison)
    {
        super(ExceptionAuthorizationFailedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionAuthorizationFailed(String orb_reason, String raison)
    {
        super(ExceptionAuthorizationFailedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
