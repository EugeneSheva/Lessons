package hiber;

public class UsersHelper extends DAO<Users> {

    protected UsersHelper() {
        super(Users.class);
    }

//    public Users updatePhoneNumb (Integer id, Integer phoneNumb) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("Open session");
//
//        session.beginTransaction();
//        Users users = session.get(Users.class, id);
//        users.setPhonenumber(phoneNumb);
//        session.save(users);
//        System.out.println("Complete");
//        session.getTransaction().commit();
//        return users;
//    }
//    public Users updateAddress (Integer id, String address) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("Open session");
//
//        session.beginTransaction();
//        Users users = session.get(Users.class, id);
//        users.setAddress(address);
//        session.save(users);
//        System.out.println("Complete");
//        session.getTransaction().commit();
//        return users;
//    }
//    public Users updatePassword (Integer id, String password) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("Open session");
//
//        session.beginTransaction();
//        Users users = session.get(Users.class, id);
//        users.setPassword(password);
//        session.save(users);
//        System.out.println("Complete");
//        session.getTransaction().commit();
//        return users;
//    }

}
