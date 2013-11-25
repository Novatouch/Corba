package LivreEnLigne;

/** 
 * Helper class for : Mandataire
 *  
 * @author OpenORB Compiler
 */ 
public class MandataireHelper
{
    /**
     * Insert Mandataire into an any
     * @param a an any
     * @param t Mandataire value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.Mandataire t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Mandataire from an any
     * @param a an any
     * @return the extracted Mandataire value
     */
    public static LivreEnLigne.Mandataire extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return LivreEnLigne.MandataireHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Mandataire TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Mandataire");
        }
        return _tc;
    }

    /**
     * Return the Mandataire IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/Mandataire:1.0";

    /**
     * Read Mandataire from a marshalled stream
     * @param istream the input stream
     * @return the readed Mandataire value
     */
    public static LivreEnLigne.Mandataire read(org.omg.CORBA.portable.InputStream istream)
    {
        return(LivreEnLigne.Mandataire)istream.read_Object(LivreEnLigne._MandataireStub.class);
    }

    /**
     * Write Mandataire into a marshalled stream
     * @param ostream the output stream
     * @param value Mandataire value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.Mandataire value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Mandataire
     * @param obj the CORBA Object
     * @return Mandataire Object
     */
    public static Mandataire narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Mandataire)
            return (Mandataire)obj;

        if (obj._is_a(id()))
        {
            _MandataireStub stub = new _MandataireStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Mandataire
     * @param obj the CORBA Object
     * @return Mandataire Object
     */
    public static Mandataire unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Mandataire)
            return (Mandataire)obj;

        _MandataireStub stub = new _MandataireStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
