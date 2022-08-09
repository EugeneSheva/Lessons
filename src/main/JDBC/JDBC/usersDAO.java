package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersDAO  extends Configs implements IuserDAO  {

        public void add(Users users) {
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = getConnection();
                statement = connection.prepareStatement(INSERT);

                statement.setString(1, users.getName());
                statement.setInt(2,users.getPhonenumber());
                statement.setString(3, users.getAddress());
                statement.setString(4, users.getUsername());
                statement.setString(5, users.getPassword());



                statement.execute();
                System.out.println("ok");

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


        public List<Users> getAll() {
            List<Users>allUsers = new ArrayList<>();
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = getConnection();
                statement = connection.prepareStatement("SELECT name, phonenumber, address, username, password FROM users; ");
                ResultSet rs = statement.executeQuery();

                while (rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int phonenumber = rs.getInt(3);
                    String address = rs.getString(4);
                    String username = rs.getString(5);
                    String password = rs.getString(6);
                    Users users = new Users();
                    users.setIduser(id);
                    users.setName(name);
                    users.setPhonenumber(phonenumber);
                    users.setAddress(address);
                    users.setUsername(username);
                    users.setPassword(password);
                    allUsers.add(users);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return allUsers;
        }


        public Users getById(int id) {
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = getConnection();
                statement = connection.prepareStatement(GET_BY_ID);
                statement.setInt(1,id);
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    int iduser1 = rs.getInt(1);
                    String name1 = rs.getString(2);
                    int phonenumber1 = rs.getInt(3);
                    String address1 = rs.getString(4);
                    String username1 = rs.getString(5);
                    String password1 = rs.getString(6);
                    Users users = new Users();
                    users.setIduser(iduser1);
                    users.setName(name1);
                    users.setPhonenumber(phonenumber1);
                    users.setAddress(address1);
                    users.setUsername(username1);
                    users.setPassword(password1);
                    return users;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public void updateUsers(int phonenumb, int userId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1,phonenumb);
            statement.setInt(2,userId);
            statement.executeUpdate();
            System.out.println("Values "+ userId + " updated.");
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
        String GET_BY_ID = "SELECT iduser, name, phonenumber, address, username, password FROM users WHERE iduser = ?";
        String INSERT = "INSERT INTO users (name, phonenumber, address, username, password) VALUES (?,?,?,?,?);";
        String DELETE = "DELETE FROM users WHERE iduser = (?);";
        String UPDATE = "UPDATE users SET phonenumber = ? WHERE iduser = ?";
}
