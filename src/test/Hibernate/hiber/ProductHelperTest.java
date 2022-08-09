package hiber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductHelperTest {
    String nameOfAddObj = "test Junit6";
    Integer updateQualitySize = 26;
    Integer idOfDeleted = 62;

    @Test
    void testAdd() {
        System.out.println("Test add");
        Product obj = new Product(nameOfAddObj, 99,99);
        ProductHelper oh = new ProductHelper();
        Integer id = oh.add(obj);
        Assertions.assertTrue(id > 0);
        System.out.println("Complete add" + obj);
    }

    @Test
    void testGetBuId() {
        System.out.println("Test getByIdByName");
        Product obj = new Product();
        ProductHelper oh = new ProductHelper();
        obj = oh.getBuId(1);
        Assertions.assertEquals("Iphone 13",obj.getProductname());
        System.out.println("Complete getByIdByName"+ obj);

    }
    @Test
    void testGetBuIdNotNull() {
        System.out.println("Test getByIdNoyNull");
        Product obj = new Product();
        ProductHelper oh = new ProductHelper();
        obj = oh.getBuId(1);
        Assertions.assertNotNull(obj);
        System.out.println("Complete getByIdNotNull"+ obj);

    }

    @Test
    void testGetList() {
        System.out.println("Test getListIsEmpty");
        ProductHelper oh = new ProductHelper();
        List<Product>obj = new ArrayList<>();
        obj = oh.getList();
        Assertions.assertFalse(obj.isEmpty());
        System.out.println("Complete getListIsEmpty"+ obj);
    }
@Test
    void testGetListBySizeArr() {
        System.out.println("Test getListBySizeArr");
        ProductHelper oh = new ProductHelper();
        List<Product>obj = new ArrayList<>();
        obj = oh.getList();
        Assertions.assertTrue(obj.size()>0);
        System.out.println("Complete getListBySizeArr"+ obj);
    }

    @Test
    void testDeleteById() {
        System.out.println("Test deleteById");
        ProductHelper oh = new ProductHelper();
        oh.delete(idOfDeleted);
        Assertions.assertNull(oh.getBuId(idOfDeleted));
        System.out.println("Complete deleteById" );
    }
//    @Test
//    void testDeletedArrSize() {
//        System.out.println("Test deleteArrSize");
//        ProductHelper oh = new ProductHelper();
//        List<Product>before = oh.getList();
//        oh.delete(idOfDeleted);
//        List<Product>after = oh.getList();
//        Assertions.assertTrue(after.size()-before.size()==-1);
//        System.out.println("Complete deleteArrSize" );
//    }


    @Test
    void testUpdate() {
        System.out.println("Test update");

        Product obj = new Product(1,"Iphone 13", 1400,updateQualitySize);
        ProductHelper oh = new ProductHelper();
        Product updatedObj = oh.update(obj);
        Assertions.assertTrue(obj.equals(updatedObj));
        System.out.println("Complete update" + updatedObj);

    }

}