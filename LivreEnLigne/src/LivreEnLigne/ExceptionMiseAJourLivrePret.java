package LivreEnLigne;

/**
 * Exception definition : ExceptionMiseAJourLivrePret
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionMiseAJourLivrePret extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionMiseAJourLivrePret()
    {
        super(ExceptionMiseAJourLivrePretHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionMiseAJourLivrePret(String raison)
    {
        super(ExceptionMiseAJourLivrePretHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionMiseAJourLivrePret(String orb_reason, String raison)
    {
        super(ExceptionMiseAJourLivrePretHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
