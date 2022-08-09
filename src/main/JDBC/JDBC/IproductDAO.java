package JDBC;

import java.util.List;

public interface IproductDAO {
    void add (Product product);
    List<Product> getAll();
    Product getById(int id);
    void updatePrice (int price, int productId);
    void remove(int id);
}
