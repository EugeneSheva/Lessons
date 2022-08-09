package hiber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersHelperTest {
    String nameOfAddObj = "test users5";
    Integer updatePhonenumber = 7456277;
    Integer idOfDeleted = 15;

    @Test
    void testAdd() {
        System.out.println("Test add");
        Users obj = new Users(nameOfAddObj,12345678,"test","test","test");
        UsersHelper oh = new UsersHelper();
        Integer id = oh.add(obj);
        Assertions.assertTrue(id > 0);
        System.out.println("Complete add" + obj);
    }

    @Test
    void testGetBuId() {
        System.out.println("Test getByIdByName");
        Users obj = new Users();
        UsersHelper oh = new UsersHelper();
        obj = oh.getBuId(1);
        Assertions.assertEquals("Антон Смаглий",obj.getName());
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
        UsersHelper oh = new UsersHelper();
        List<Users> obj = new ArrayList<>();
        obj = oh.getList();
        Assertions.assertFalse(obj.isEmpty());
        System.out.println("Complete getListIsEmpty"+ obj);
    }
    @Test
    void testGetListBySizeArr() {
        System.out.println("Test getListBySizeArr");
        UsersHelper oh = new UsersHelper();
        List<Users>obj = new ArrayList<>();
        obj = oh.getList();
        Assertions.assertTrue(obj.size()>0);
        System.out.println("Complete getListBySizeArr"+ obj);
    }

    @Test
    void testDeleteById() {
        System.out.println("Test deleteById");
        UsersHelper oh = new UsersHelper();
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

        Users obj = new Users(1,"Антон Смаглий",updatePhonenumber, "Харьков, пр-т Победы 62, кв 7","Antom100","qwerty");
        UsersHelper oh = new UsersHelper();
        Users updatedObj = oh.update(obj);
        Assertions.assertTrue(obj.equals(updatedObj));
        System.out.println("Complete update" + updatedObj);

    }

}