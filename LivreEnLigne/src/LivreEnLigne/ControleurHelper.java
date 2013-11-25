package LivreEnLigne;

/** 
 * Helper class for : Controleur
 *  
 * @author OpenORB Compiler
 */ 
public class ControleurHelper
{
    /**
     * Insert Controleur into an any
     * @param a an any
     * @param t Controleur value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.Controleur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Controleur from an any
     * @param a an any
     * @return the extracted Controleur value
     */
    public static LivreEnLigne.Controleur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return LivreEnLigne.ControleurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Controleur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Controleur");
        }
        return _tc;
    }

    /**
     * Return the Controleur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/Controleur:1.0";

    /**
     * Read Controleur from a marshalled stream
     * @param istream the input stream
     * @return the readed Controleur value
     */
    public static LivreEnLigne.Controleur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(LivreEnLigne.Controleur)istream.read_Object(LivreEnLigne._ControleurStub.class);
    }

    /**
     * Write Controleur into a marshalled stream
     * @param ostream the output stream
     * @param value Controleur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.Controleur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Controleur
     * @param obj the CORBA Object
     * @return Controleur Object
     */
    public static Controleur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Controleur)
            return (Controleur)obj;

        if (obj._is_a(id()))
        {
            _ControleurStub stub = new _ControleurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Controleur
     * @param obj the CORBA Object
     * @return Controleur Object
     */
    public static Controleur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Controleur)
            return (Controleur)obj;

        _ControleurStub stub = new _ControleurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
