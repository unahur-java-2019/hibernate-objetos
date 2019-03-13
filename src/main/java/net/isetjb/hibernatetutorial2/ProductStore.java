package net.isetjb.hibernatetutorial2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductStore {
    private Session session;

    public ProductStore() {
        session = HibernateUtil.getSession();
    }

    void close() {
        session.close();
    }

    void deleteAll() {
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM Product").executeUpdate();
        transaction.commit();
    }

    /**
     * Method to save Product in database.
     *
     * @param product
     */
    public void add(Product product) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
        }
    }

    /**
     * Method to get list of all Products.
     */
    public List<Product> all() {
        return session.createQuery("FROM Product", Product.class).getResultList();
    }
}
