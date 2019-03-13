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
        session.createNativeQuery("DELETE FROM product").executeUpdate();
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

            int inserted_id = (Integer) session.save(product);
            System.err.println("Inserted ID : " + inserted_id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * Method to get list of all Products.
     */
    public List<Product> all() {
        return session.createQuery("FROM Product", Product.class).getResultList();
    }

    /**
     * Method to update one Product.
     *
     * @param id
     * @param name
     * @param price
     */
    public void update(int id, String name, int price) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // get the product by id
            Product product = (Product) session.get(Product.class, id);

            product.setName(name);
            product.setPrice(price);

            session.update(product);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * Method to delete one Product.
     *
     * @param id
     */
    public void delete(int id) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // get the product by id
            Product product = (Product) session.get(Product.class, id);

            session.delete(product);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
