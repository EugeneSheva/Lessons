package JDBC;

public class DAOfactory implements IDAOfactory {

    private static IDAOfactory IDAOfactory;

    private DAOfactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static synchronized IDAOfactory getInstance() {
        if (IDAOfactory == null) {
            IDAOfactory = new DAOfactory();
        }
        return IDAOfactory;
    }

    @Override
    public IproductDAO getproductDAO() {
        return new productDAO();
    }

    @Override
    public IuserDAO getusersDAO() {
        return null;
    }
}
