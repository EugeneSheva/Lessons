package JDBC;

import java.util.List;

public interface IuserDAO {
    void add (Users users);
    List<Users> getAll();
    Users getById(int id);
    void updateUsers (int price, int productId);
    void remove(int id);
}
