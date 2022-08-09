package hiber;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    public Product(int idproduct, String productname, int productprice, int productquantity) {
        this.idproduct = idproduct;
        this.productname = productname;
        this.productprice = productprice;
        this.productquantity = productquantity;
    }

    public Product(String productname, int productprice, int productquantity) {
        this.productname = productname;
        this.productprice = productprice;
        this.productquantity = productquantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproduct;
    private String productname;
    private int productprice;
    private int productquantity;
    private String productdescription;

    public List<Shopingcard> getShopingcardss() {
        return shopingcardss;
    }

    public void setShopingcardss(List<Shopingcard> shopingcardss) {
        this.shopingcardss = shopingcardss;
    }

    @ManyToMany (cascade = {CascadeType.PERSIST, },fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "or_product"),
            inverseJoinColumns =@JoinColumn(name = "or_id"))
    private List<Shopingcard> shopingcardss = new ArrayList<Shopingcard>();

    public Product() {

    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    public int getProductquantity() {
        return productquantity;
    }



    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }
    @Override
    public String toString() {
        return "\n" + "id = " + idproduct + ", name: " + productname + ", price = " + productprice + ", quantity = " + productquantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idproduct == product.idproduct && productprice == product.productprice && productquantity == product.productquantity && Objects.equals(productname, product.productname) && Objects.equals(productdescription, product.productdescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, productname, productprice, productquantity, productdescription, shopingcardss);
    }
}
