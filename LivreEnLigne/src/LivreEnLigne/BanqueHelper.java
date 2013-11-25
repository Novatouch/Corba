package LivreEnLigne;

/** 
 * Helper class for : Banque
 *  
 * @author OpenORB Compiler
 */ 
public class BanqueHelper
{
    /**
     * Insert Banque into an any
     * @param a an any
     * @param t Banque value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.Banque t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Banque from an any
     * @param a an any
     * @return the extracted Banque value
     */
    public static LivreEnLigne.Banque extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return LivreEnLigne.BanqueHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Banque TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Banque");
        }
        return _tc;
    }

    /**
     * Return the Banque IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/Banque:1.0";

    /**
     * Read Banque from a marshalled stream
     * @param istream the input stream
     * @return the readed Banque value
     */
    public static LivreEnLigne.Banque read(org.omg.CORBA.portable.InputStream istream)
    {
        return(LivreEnLigne.Banque)istream.read_Object(LivreEnLigne._BanqueStub.class);
    }

    /**
     * Write Banque into a marshalled stream
     * @param ostream the output stream
     * @param value Banque value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.Banque value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Banque
     * @param obj the CORBA Object
     * @return Banque Object
     */
    public static Banque narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Banque)
            return (Banque)obj;

        if (obj._is_a(id()))
        {
            _BanqueStub stub = new _BanqueStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Banque
     * @param obj the CORBA Object
     * @return Banque Object
     */
    public static Banque unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Banque)
            return (Banque)obj;

        _BanqueStub stub = new _BanqueStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
