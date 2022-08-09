package hiber;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class DAO<E> {
    private final Class<E> clazz;

    protected DAO(Class<E> clazz) {
        this.clazz = clazz;
    }

    public Integer add(E entity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Open session");

        session.beginTransaction();
        Integer id = (Integer) session.save(entity);
        System.out.println("Complete");
        session.getTransaction().commit();
        return id;
    }

    public E getBuId(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Open session");

        E entity = session.find(clazz, id);
        session.close();
        System.out.println(entity);
        return entity;
    }

    public List<E> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Open session");

//        Criteria cr = session.createCriteria(clazz);
//        List<E> list = cr.list();
//        устаревший метод

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cr = cb.createQuery(clazz);
        Root<E> root = cr.from(clazz);
        cr.select(root);
        Query<E> query = session.createQuery(cr);
        List<E> list = query.getResultList();

        System.out.println("Complete");
        session.close();
        System.out.println(list);
        return list;
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("Open session");
        E entity = session.get(clazz, id);
        session.delete(entity);
        session.getTransaction().commit();
        System.out.println("delete");
        session.close();
    }

    public E update (E entity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Open session");
        session.beginTransaction();
        E updatedEntity = (E) session.merge(entity);
        System.out.println("Complete update");
        session.getTransaction().commit();
        return updatedEntity;
    }



}
