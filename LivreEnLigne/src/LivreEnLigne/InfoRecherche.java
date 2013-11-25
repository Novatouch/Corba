package LivreEnLigne;

/**
 * Struct definition : InfoRecherche
 * 
 * @author OpenORB Compiler
*/
public final class InfoRecherche implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member fournisseur
     */
    public String fournisseur;

    /**
     * Struct member prix
     */
    public float prix;

    /**
     * Default constructor
     */
    public InfoRecherche()
    { }

    /**
     * Constructor with fields initialization
     * @param fournisseur fournisseur struct member
     * @param prix prix struct member
     */
    public InfoRecherche(String fournisseur, float prix)
    {
        this.fournisseur = fournisseur;
        this.prix = prix;
    }

}
