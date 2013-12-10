package LivreEnLigne;

/**
 * Exception definition : ExceptionPretNotSaved
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionPretNotSaved extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionPretNotSaved()
    {
        super(ExceptionPretNotSavedHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionPretNotSaved(String raison)
    {
        super(ExceptionPretNotSavedHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionPretNotSaved(String orb_reason, String raison)
    {
        super(ExceptionPretNotSavedHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
