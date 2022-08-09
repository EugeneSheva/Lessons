package JDBC;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IDAOfactory idaOfactory = DAOfactory.getInstance();
        IproductDAO iproductDAO = idaOfactory.getproductDAO();


        //get All
        List<Product> Plist = iproductDAO.getAll();
        for (Product product1 : Plist) {
            System.out.println(product1);
        }
        //add
        Product product = new Product();
        product.setProductname("Test3");
        product.setProductprice(999);
        product.setProductquantity(999);
        iproductDAO.add(product);

        //update price
        iproductDAO.updatePrice(1400,1);
        //get by id
        Product product2 = iproductDAO.getById(1);
        System.out.println(product2);
        //delete
        iproductDAO.remove(18);
        //get All
        List<Product> Plist2 = iproductDAO.getAll();
        for (Product product1 : Plist2) {
            System.out.println(product1);
        }

    }
}
