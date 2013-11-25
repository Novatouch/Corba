package LivreEnLigne;

/** 
 * Helper class for : Fournisseur
 *  
 * @author OpenORB Compiler
 */ 
public class FournisseurHelper
{
    /**
     * Insert Fournisseur into an any
     * @param a an any
     * @param t Fournisseur value
     */
    public static void insert(org.omg.CORBA.Any a, LivreEnLigne.Fournisseur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Fournisseur from an any
     * @param a an any
     * @return the extracted Fournisseur value
     */
    public static LivreEnLigne.Fournisseur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return LivreEnLigne.FournisseurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Fournisseur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Fournisseur");
        }
        return _tc;
    }

    /**
     * Return the Fournisseur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:LivreEnLigne/Fournisseur:1.0";

    /**
     * Read Fournisseur from a marshalled stream
     * @param istream the input stream
     * @return the readed Fournisseur value
     */
    public static LivreEnLigne.Fournisseur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(LivreEnLigne.Fournisseur)istream.read_Object(LivreEnLigne._FournisseurStub.class);
    }

    /**
     * Write Fournisseur into a marshalled stream
     * @param ostream the output stream
     * @param value Fournisseur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, LivreEnLigne.Fournisseur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Fournisseur
     * @param obj the CORBA Object
     * @return Fournisseur Object
     */
    public static Fournisseur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Fournisseur)
            return (Fournisseur)obj;

        if (obj._is_a(id()))
        {
            _FournisseurStub stub = new _FournisseurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Fournisseur
     * @param obj the CORBA Object
     * @return Fournisseur Object
     */
    public static Fournisseur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Fournisseur)
            return (Fournisseur)obj;

        _FournisseurStub stub = new _FournisseurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
