package LivreEnLigne;

/**
 * Exception definition : MiseAJourLivreExeption
 * 
 * @author OpenORB Compiler
 */
public final class MiseAJourLivreExeption extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public MiseAJourLivreExeption()
    {
        super(MiseAJourLivreExeptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public MiseAJourLivreExeption(String raison)
    {
        super(MiseAJourLivreExeptionHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public MiseAJourLivreExeption(String orb_reason, String raison)
    {
        super(MiseAJourLivreExeptionHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
