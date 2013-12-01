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
    public String compte;

    /**
     * Struct member code
     */
    public String code;

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
    public InfoBancaires(String compte, String code)
    {
        this.compte = compte;
        this.code = code;
    }

}
