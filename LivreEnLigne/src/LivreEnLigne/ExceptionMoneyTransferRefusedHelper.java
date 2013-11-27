package LivreEnLigne;

/** 
 * Helper class for : ExceptionMoneyTransferRefused
 *  
 * @author OpenORB Compiler
 */ 
public class ExceptionMoneyTransferRefusedHelper
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
     * Insert ExceptionMoneyTransferRefused into an any
     * @param a an any
     * @param t ExceptionMoneyTransferRefused value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.ExceptionMoneyTransferRefused t)
    {
        a.insert_Streamable(new LivreEnLigne.ExceptionMoneyTransferRefusedHolder(t));
    }

    /**
     * Extract ExceptionMoneyTransferRefused from an any
     * @param a an any
     * @return the extracted ExceptionMoneyTransferRefused value
     */
    public static LivreEnLigne.ExceptionMoneyTransferRefused extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof LivreEnLigne.ExceptionMoneyTransferRefusedHolder)
                    return ((LivreEnLigne.ExceptionMoneyTransferRefusedHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            LivreEnLigne.ExceptionMoneyTransferRefusedHolder h = new LivreEnLigne.ExceptionMoneyTransferRefusedHolder(read(a.create_input_stream()));
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
     * Return the ExceptionMoneyTransferRefused TypeCode
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
                _tc = orb.create_exception_tc(id(),"ExceptionMoneyTransferRefused",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the ExceptionMoneyTransferRefused IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/ExceptionMoneyTransferRefused:1.0";

    /**
     * Read ExceptionMoneyTransferRefused from a marshalled stream
     * @param istream the input stream
     * @return the readed ExceptionMoneyTransferRefused value
     */
    public static LivreEnLigne.ExceptionMoneyTransferRefused read(org.omg.CORBA.portable.InputStream istream)
    {
        LivreEnLigne.ExceptionMoneyTransferRefused new_one = new LivreEnLigne.ExceptionMoneyTransferRefused();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();

        return new_one;
    }

    /**
     * Write ExceptionMoneyTransferRefused into a marshalled stream
     * @param ostream the output stream
     * @param value ExceptionMoneyTransferRefused value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.ExceptionMoneyTransferRefused value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
    }

}
