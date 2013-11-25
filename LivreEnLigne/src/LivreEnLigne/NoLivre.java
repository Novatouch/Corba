package LivreEnLigne;

/**
 * Exception definition : NoLivre
 * 
 * @author OpenORB Compiler
 */
public final class NoLivre extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public NoLivre()
    {
        super(NoLivreHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public NoLivre(String raison)
    {
        super(NoLivreHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public NoLivre(String orb_reason, String raison)
    {
        super(NoLivreHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
