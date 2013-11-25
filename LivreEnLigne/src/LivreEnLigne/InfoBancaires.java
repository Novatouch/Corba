package LivreEnLigne;

/**
 * Struct definition : InfoBancaires
 * 
 * @author OpenORB Compiler
*/
public final class InfoBancaires implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member compte
     */
    public int compte;

    /**
     * Struct member code
     */
    public int code;

    /**
     * Default constructor
     */
    public InfoBancaires()
    { }

    /**
     * Constructor with fields initialization
     * @param compte compte struct member
     * @param code code struct member
     */
    public InfoBancaires(int compte, int code)
    {
        this.compte = compte;
        this.code = code;
    }

}
