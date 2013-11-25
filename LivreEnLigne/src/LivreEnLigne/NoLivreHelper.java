package LivreEnLigne;

/** 
 * Helper class for : NoLivre
 *  
 * @author OpenORB Compiler
 */ 
public class NoLivreHelper
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
     * Insert NoLivre into an any
     * @param a an any
     * @param t NoLivre value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.NoLivre t)
    {
        a.insert_Streamable(new LivreEnLigne.NoLivreHolder(t));
    }

    /**
     * Extract NoLivre from an any
     * @param a an any
     * @return the extracted NoLivre value
     */
    public static LivreEnLigne.NoLivre extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof LivreEnLigne.NoLivreHolder)
                    return ((LivreEnLigne.NoLivreHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            LivreEnLigne.NoLivreHolder h = new LivreEnLigne.NoLivreHolder(read(a.create_input_stream()));
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
     * Return the NoLivre TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "raison";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"NoLivre",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the NoLivre IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/NoLivre:1.0";

    /**
     * Read NoLivre from a marshalled stream
     * @param istream the input stream
     * @return the readed NoLivre value
     */
    public static LivreEnLigne.NoLivre read(org.omg.CORBA.portable.InputStream istream)
    {
        LivreEnLigne.NoLivre new_one = new LivreEnLigne.NoLivre();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();

        return new_one;
    }

    /**
     * Write NoLivre into a marshalled stream
     * @param ostream the output stream
     * @param value NoLivre value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.NoLivre value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
    }

}
