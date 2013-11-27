package LivreEnLigne;

/**
 * Exception definition : ExceptionNoLivreFound
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionNoLivreFound extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionNoLivreFound()
    {
        super(ExceptionNoLivreFoundHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionNoLivreFound(String raison)
    {
        super(ExceptionNoLivreFoundHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionNoLivreFound(String orb_reason, String raison)
    {
        super(ExceptionNoLivreFoundHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
