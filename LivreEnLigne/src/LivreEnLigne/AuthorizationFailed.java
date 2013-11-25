package LivreEnLigne;

/**
 * Exception definition : AuthorizationFailed
 * 
 * @author OpenORB Compiler
 */
public final class AuthorizationFailed extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public AuthorizationFailed()
    {
        super(AuthorizationFailedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public AuthorizationFailed(String raison)
    {
        super(AuthorizationFailedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public AuthorizationFailed(String orb_reason, String raison)
    {
        super(AuthorizationFailedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
