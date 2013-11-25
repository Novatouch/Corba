package LivreEnLigne;

/** 
 * Helper class for : Lecteur
 *  
 * @author OpenORB Compiler
 */ 
public class LecteurHelper
{
    /**
     * Insert Lecteur into an any
     * @param a an any
     * @param t Lecteur value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.Lecteur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Lecteur from an any
     * @param a an any
     * @return the extracted Lecteur value
     */
    public static LivreEnLigne.Lecteur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return LivreEnLigne.LecteurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Lecteur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Lecteur");
        }
        return _tc;
    }

    /**
     * Return the Lecteur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/Lecteur:1.0";

    /**
     * Read Lecteur from a marshalled stream
     * @param istream the input stream
     * @return the readed Lecteur value
     */
    public static LivreEnLigne.Lecteur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(LivreEnLigne.Lecteur)istream.read_Object(LivreEnLigne._LecteurStub.class);
    }

    /**
     * Write Lecteur into a marshalled stream
     * @param ostream the output stream
     * @param value Lecteur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.Lecteur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Lecteur
     * @param obj the CORBA Object
     * @return Lecteur Object
     */
    public static Lecteur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Lecteur)
            return (Lecteur)obj;

        if (obj._is_a(id()))
        {
            _LecteurStub stub = new _LecteurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Lecteur
     * @param obj the CORBA Object
     * @return Lecteur Object
     */
    public static Lecteur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Lecteur)
            return (Lecteur)obj;

        _LecteurStub stub = new _LecteurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
