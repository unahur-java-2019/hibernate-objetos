package net.isetjb.hibernatetutorial2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Application class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class Application {

    private static Session session;

    /**
     * Attribute declaration for factory to share between methods.
     */
    public static void main(String[] args) {
        session = HibernateUtil.getSession();

        borrarProductos();
        addProduct("ff", 44);
        addProduct("gg", 22);
        listProducts();
        updateProduct(4, "aaa", 44);
        updateProduct(5, "bbb", 55);
        deleteProduct(6);
        deleteProduct(7);
        listProducts();

        session.close();
        HibernateUtil.closeSessionFactory();
    }

    private static void borrarProductos() {
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM product").executeUpdate();
        transaction.commit();
    }

    /**
     * Method to save Product in database.
     *
     * @param name
     * @param price
     */
    public static void addProduct(String name, int price) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // insert new product
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
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
    public static void listProducts() {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Get products by executing HQL Query
            List products = session.createQuery("FROM Product").list();

            for (Iterator iterator = products.iterator(); iterator.hasNext(); ) {
                Product product = (Product) iterator.next();
                System.out.print("ID: " + product.getId());
                System.out.print(" ===> NAME: " + product.getName());
                System.out.println(" ===> PRICE: " + product.getPrice());
            }

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
     * Method to update one Product.
     *
     * @param id
     * @param name
     * @param price
     */
    public static void updateProduct(int id, String name, int price) {
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
    public static void deleteProduct(int id) {
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
