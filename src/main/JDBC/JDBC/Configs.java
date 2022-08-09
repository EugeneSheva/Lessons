package JDBC;

public class Configs {
    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = "root";
    protected String dbName = "localconnection";

    protected String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

    public static final String USER_TABLE = "users";
    public static final String USERS_ID = "iduser";
    public static final String USER_FIRSTNAME = "firstname";
    public static final String USER_LASTNAME = "lastname";
    public static final String USER_PHONENUMBER = "phonenumber";
    public static final String USER_ADDRESS = "address";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";

    public static final String PRODUCT_TABLE = "product";
    public static final String PRODUCT_ID = "idproduct";
    public static final String PRODUCT_NAME = "productname";
    public static final String PRODUCT_PRICE = "productprice";
    public static final String PRODUCT_QUANTITY = "productquantity";
    public static final String PRODUCT_DESCRIPTION = "productdescriotion";
}
