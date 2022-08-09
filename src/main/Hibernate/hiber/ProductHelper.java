package hiber;

public class ProductHelper extends DAO<Product> {


    protected ProductHelper() {
        super(Product.class);
    }

//    public Product updatePrice (Integer id, Integer price) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("Open session");
//
//        session.beginTransaction();
//        Product product = session.get(Product.class, id);
//        product.setProductprice(price);
//        session.save(product);
//        System.out.println("Complete");
//        session.getTransaction().commit();
//        return product;
//    }
//
//    public Product updateQuantity (Integer id, Integer quantity) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("Open session");
//
//        session.beginTransaction();
//        Product product = session.get(Product.class, id);
//        product.setProductquantity(quantity);
//        session.save(product);
//        System.out.println("Complete");
//        session.getTransaction().commit();
//        return product;
//    }
}
