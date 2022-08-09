package hiber;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shopingcard")
public class Shopingcard implements Serializable {

    public Shopingcard(Users user) {
        this.user = user;
        this.sc_date = new Date();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_shopingcard;
    @Temporal(TemporalType.DATE)
    private Date sc_date;
    @ManyToOne (optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cs_user_id")
    private Users user;

    public Shopingcard(int id_shopingcard, Users user, List<Product> productss) {
        this.id_shopingcard = id_shopingcard;
        this.sc_date = new Date();
        this.user = user;
        this.productss = productss;
    }

    public Shopingcard(Users user, List<Product> productss) {
        this.sc_date = new Date();
        this.user = user;
        this.productss = productss;
    }

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "or_id"),
            inverseJoinColumns =@JoinColumn(name = "or_product"))
    private List<Product> productss = new ArrayList<>();

    public void addProduct(Product product) {
        productss.add(product);
        product.getShopingcardss().add(this);
    }

    public void removeProduct(Product product) {
        productss.remove(product);
        product.getShopingcardss().remove(this);
    }

    public Shopingcard() {

    }

    public int getId_shopingcard() {
        return id_shopingcard;
    }

    public void setId_shopingcard(int id_shopingcard) {
        this.id_shopingcard = id_shopingcard;
    }

    public Date getSc_date() {
        return sc_date;
    }

    public void setSc_date(Date sc_date) {
        this.sc_date = sc_date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users users) {
        this.user = users;
    }

    @Override
    public String toString() {
        return "\n" + "order id " + id_shopingcard + ", date: " + sc_date + ", user: " + user.getName()+ ", " + user.getAddress() + ", " + user.getPhonenumber()+", заказ: " + productss;
//        return "\n" + "order id " + id_shopingcard + ", date " + sc_date + ", user: " + users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shopingcard)) return false;
        Shopingcard that = (Shopingcard) o;
        return id_shopingcard == that.id_shopingcard && sc_date.equals(that.sc_date) && (user.getIduser()==that.user.getIduser()) && productss.containsAll(that.productss);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id_shopingcard, sc_date, user, productss);
    }
}

