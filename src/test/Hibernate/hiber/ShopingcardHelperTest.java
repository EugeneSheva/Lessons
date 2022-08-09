package hiber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShopingcardHelperTest {
    Integer idOfDeleted = 8;

    @Test
    void testAdd() {
        System.out.println("Test add");
        ProductHelper ph = new ProductHelper();
        ShopingcardHelper sh = new ShopingcardHelper();
        UsersHelper uh = new UsersHelper();
        Product p1 = ph.getBuId(7);
        Product p2 = ph.getBuId(9);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        Users us = uh.getBuId(1);
        Shopingcard shopcd = new Shopingcard(us,products);
        Integer id = sh.add(shopcd);
        Assertions.assertTrue(id > 0);
        System.out.println("Complete add" + shopcd);
    }

    @Test
    void testGetBuId() {
        System.out.println("Test getByIdByName");
        Shopingcard obj = new Shopingcard();
        ShopingcardHelper oh = new ShopingcardHelper();
        obj = oh.getBuId(1);
        Assertions.assertEquals("Степан Шматченко",obj.getUser().getName());
        System.out.println("Complete getByIdByName"+ obj);

    }
    @Test
    void testGetBuIdNotNull() {
        System.out.println("Test getByIdNoyNull");
        Users obj = new Users();
        UsersHelper oh = new UsersHelper();
        obj = oh.getBuId(1);
        Assertions.assertNotNull(obj);
        System.out.println("Complete getByIdNotNull"+ obj);

    }

    @Test
    void testGetList() {
        System.out.println("Test getListIsEmpty");
        ShopingcardHelper oh = new ShopingcardHelper();
        List<Shopingcard> obj = new ArrayList<>();
        obj = oh.getList();
        Assertions.assertFalse(obj.isEmpty());
        System.out.println("Complete getListIsEmpty"+ obj);
    }
    @Test
    void testGetListBySizeArr() {
        System.out.println("Test getListBySizeArr");
        ShopingcardHelper oh = new ShopingcardHelper();
        List<Shopingcard>obj = new ArrayList<>();
        obj = oh.getList();
        Assertions.assertTrue(obj.size()>0);
        System.out.println("Complete getListBySizeArr"+ obj);
    }

    @Test
    void testDeleteById() {
        System.out.println("Test deleteById");
        ShopingcardHelper oh = new ShopingcardHelper();
        oh.delete(idOfDeleted);
        Assertions.assertNull(oh.getBuId(idOfDeleted));
        System.out.println("Complete deleteById" );
    }
//    @Test
//    void testDeletedArrSize() {
//        System.out.println("Test deleteArrSize");
//        UsersHelper oh = new UsersHelper();
//        List<Users>before = oh.getList();
//        oh.delete(idOfDeleted);
//        List<Users>after = oh.getList();
//        Assertions.assertTrue(after.size()-before.size()==-1);
//        System.out.println("Complete deleteArrSize" );
//    }


    @Test
    void testUpdate() {
        System.out.println("Test update");
        ProductHelper ph = new ProductHelper();
        ShopingcardHelper sh = new ShopingcardHelper();
        UsersHelper uh = new UsersHelper();
        Product p1 = ph.getBuId(7);
        Product p2 = ph.getBuId(9);
        Product p3 = ph.getBuId(10);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
//        products.add(p3);
        Users us = uh.getBuId(1);
        Shopingcard shopcd = new Shopingcard(9,us,products);
        Shopingcard updatedObj = sh.update(shopcd);
        Assertions.assertEquals(updatedObj, shopcd);
        System.out.println("Complete update" + updatedObj);

    }
}