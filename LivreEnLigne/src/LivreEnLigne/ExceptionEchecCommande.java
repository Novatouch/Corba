package LivreEnLigne;

/**
 * Exception definition : ExceptionEchecCommande
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionEchecCommande extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ExceptionEchecCommande()
    {
        super(ExceptionEchecCommandeHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionEchecCommande(String raison)
    {
        super(ExceptionEchecCommandeHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ExceptionEchecCommande(String orb_reason, String raison)
    {
        super(ExceptionEchecCommandeHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
