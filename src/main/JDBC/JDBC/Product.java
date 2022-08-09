package JDBC;

public class Product {
    private int idproduct;
    private String productname;
    private int productprice;
    private int productquantity;
    private String productdescription;

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

    @Override
    public String toString() {
        return "id = " + idproduct + ", name: " + productname + ", price = " + productprice + ", quantity = " + productquantity + ".";
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
}



