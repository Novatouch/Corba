package LivreEnLigne;

/**
 * Exception definition : ExceptionMiseAJourLivre
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionMiseAJourLivre extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionMiseAJourLivre()
    {
        super(ExceptionMiseAJourLivreHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionMiseAJourLivre(String raison)
    {
        super(ExceptionMiseAJourLivreHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionMiseAJourLivre(String orb_reason, String raison)
    {
        super(ExceptionMiseAJourLivreHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
