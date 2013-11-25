package LivreEnLigne;

/**
 * Exception definition : EchecCommande
 * 
 * @author OpenORB Compiler
 */
public final class EchecCommande extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public EchecCommande()
    {
        super(EchecCommandeHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public EchecCommande(String raison)
    {
        super(EchecCommandeHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public EchecCommande(String orb_reason, String raison)
    {
        super(EchecCommandeHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
