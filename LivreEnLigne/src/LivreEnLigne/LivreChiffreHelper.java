package LivreEnLigne;

/** 
 * Helper class for : LivreChiffre
 *  
 * @author OpenORB Compiler
 */ 
public class LivreChiffreHelper
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
     * Insert LivreChiffre into an any
     * @param a an any
     * @param t LivreChiffre value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.LivreChiffre t)
    {
        a.insert_Streamable(new LivreEnLigne.LivreChiffreHolder(t));
    }

    /**
     * Extract LivreChiffre from an any
     * @param a an any
     * @return the extracted LivreChiffre value
     */
    public static LivreEnLigne.LivreChiffre extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof LivreEnLigne.LivreChiffreHolder)
                    return ((LivreEnLigne.LivreChiffreHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            LivreEnLigne.LivreChiffreHolder h = new LivreEnLigne.LivreChiffreHolder(read(a.create_input_stream()));
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
     * Return the LivreChiffre TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "contenu";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "cle";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"LivreChiffre",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the LivreChiffre IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/LivreChiffre:1.0";

    /**
     * Read LivreChiffre from a marshalled stream
     * @param istream the input stream
     * @return the readed LivreChiffre value
     */
    public static LivreEnLigne.LivreChiffre read(org.omg.CORBA.portable.InputStream istream)
    {
        LivreEnLigne.LivreChiffre new_one = new LivreEnLigne.LivreChiffre();

        new_one.contenu = istream.read_string();
        new_one.cle = istream.read_string();

        return new_one;
    }

    /**
     * Write LivreChiffre into a marshalled stream
     * @param ostream the output stream
     * @param value LivreChiffre value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.LivreChiffre value)
    {
        ostream.write_string(value.contenu);
        ostream.write_string(value.cle);
    }

}
