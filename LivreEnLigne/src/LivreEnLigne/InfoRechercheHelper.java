package LivreEnLigne;

/** 
 * Helper class for : InfoRecherche
 *  
 * @author OpenORB Compiler
 */ 
public class InfoRechercheHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert InfoRecherche into an any
     * @param a an any
     * @param t InfoRecherche value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.InfoRecherche t)
    {
        a.insert_Streamable(new LivreEnLigne.InfoRechercheHolder(t));
    }

    /**
     * Extract InfoRecherche from an any
     * @param a an any
     * @return the extracted InfoRecherche value
     */
    public static LivreEnLigne.InfoRecherche extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof LivreEnLigne.InfoRechercheHolder)
                    return ((LivreEnLigne.InfoRechercheHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            LivreEnLigne.InfoRechercheHolder h = new LivreEnLigne.InfoRechercheHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the InfoRecherche TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "nomFournisseur";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "iorFournisseur";
                _members[1].type = LivreEnLigne.FournisseurHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "prix";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_float);
                _tc = orb.create_struct_tc(id(),"InfoRecherche",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the InfoRecherche IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/InfoRecherche:1.0";

    /**
     * Read InfoRecherche from a marshalled stream
     * @param istream the input stream
     * @return the readed InfoRecherche value
     */
    public static LivreEnLigne.InfoRecherche read(org.omg.CORBA.portable.InputStream istream)
    {
        LivreEnLigne.InfoRecherche new_one = new LivreEnLigne.InfoRecherche();

        new_one.nomFournisseur = istream.read_string();
        new_one.iorFournisseur = LivreEnLigne.FournisseurHelper.read(istream);
        new_one.prix = istream.read_float();

        return new_one;
    }

    /**
     * Write InfoRecherche into a marshalled stream
     * @param ostream the output stream
     * @param value InfoRecherche value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.InfoRecherche value)
    {
        ostream.write_string(value.nomFournisseur);
        LivreEnLigne.FournisseurHelper.write(ostream,value.iorFournisseur);
        ostream.write_float(value.prix);
    }

}
