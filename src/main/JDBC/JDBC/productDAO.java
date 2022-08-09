package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class productDAO extends Configs implements IproductDAO {

    public void add(Product product) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, product.getProductname());
            statement.setInt(2,product.getProductprice());
            statement.setInt(3,product.getProductquantity());


            statement.execute();
            System.out.println("ok");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public List<Product> getAll() {
        List<Product>allProduct = new ArrayList<Product>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT idproduct, productname, productprice, productquantity FROM product; ");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                int quantity = rs.getInt(4);
                Product product = new Product();
                product.setIdproduct(id);
                product.setProductname(name);
                product.setProductprice(price);
                product.setProductquantity(quantity);
                allProduct.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProduct;
    }


    public Product getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int Pid = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                int quantity = rs.getInt(4);
                Product product = new Product();
                product.setIdproduct(Pid);
                product.setProductname(name);
                product.setProductprice(price);
                product.setProductquantity(quantity);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void updatePrice(int price, int productId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1,price);
            statement.setInt(2,productId);
            statement.executeUpdate();
            System.out.println("Values "+ productId + " updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void remove(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Values "+ id + " deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
            System.out.println("Connection complete.");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not connect!");
        }
        return null;
    }
    String GET_BY_ID = "SELECT idproduct, productname, productprice, productquantity FROM product WHERE idproduct = ?";
    String INSERT = "INSERT INTO product (productname, productprice, productquantity) VALUES (?,?,?);";
    String DELETE = "DELETE FROM product WHERE idproduct = (?);";
    String UPDATE = "UPDATE product SET productprice = ? WHERE idproduct = ?";
}
