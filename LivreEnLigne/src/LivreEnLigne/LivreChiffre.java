package LivreEnLigne;

/**
 * Struct definition : LivreChiffre
 * 
 * @author OpenORB Compiler
*/
public final class LivreChiffre implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member contenu
     */
    public String contenu;

    /**
     * Struct member cle
     */
    public short cle;

    /**
     * Default constructor
     */
    public LivreChiffre()
    { }

    /**
     * Constructor with fields initialization
     * @param contenu contenu struct member
     * @param cle cle struct member
     */
    public LivreChiffre(String contenu, short cle)
    {
        this.contenu = contenu;
        this.cle = cle;
    }

}
