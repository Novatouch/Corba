package LivreEnLigne;

/**
 * Struct definition : InfoRecherche
 * 
 * @author OpenORB Compiler
*/
public final class InfoRecherche implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nomFournisseur
     */
    public String nomFournisseur;

    /**
     * Struct member iorFournisseur
     */
    public LivreEnLigne.Fournisseur iorFournisseur;

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
     * @param nomFournisseur nomFournisseur struct member
     * @param iorFournisseur iorFournisseur struct member
     * @param prix prix struct member
     */
    public InfoRecherche(String nomFournisseur, LivreEnLigne.Fournisseur iorFournisseur, float prix)
    {
        this.nomFournisseur = nomFournisseur;
        this.iorFournisseur = iorFournisseur;
        this.prix = prix;
    }

}
