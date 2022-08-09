package hiber;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int iduser;

    private String name;

    private int phonenumber;
    private String address;
    private String username;
    private  String password;
    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
    private List<Shopingcard> shopingcards = new ArrayList<>();

    public Users(String name, int phonenumber, String address, String username, String password) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public Users() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return iduser == users.iduser && phonenumber == users.phonenumber && name.equals(users.name) && address.equals(users.address) && username.equals(users.username) && password.equals(users.password) && Objects.equals(shopingcards, users.shopingcards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, name, phonenumber, address, username, password, shopingcards);
    }

    public Users(int iduser, String name, int phonenumber, String address, String username, String password) {
        this.iduser = iduser;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }


    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "\n" + "id = " + iduser + ", name: " + name + ", phonenumber = " + phonenumber +", address = " + address + ", username = " + username + ", password = " + password;
    }
}

