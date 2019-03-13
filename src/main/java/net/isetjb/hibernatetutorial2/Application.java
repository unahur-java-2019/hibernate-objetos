package net.isetjb.hibernatetutorial2;

/**
 * Application class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class Application {

    /**
     * Attribute declaration for factory to share between methods.
     */
    public static void main(String[] args) {
        ProductStore store = new ProductStore();

        store.borrarProductos();
        store.addProduct("ff", 44);
        store.addProduct("gg", 22);
        store.listProducts();
        store.updateProduct(4, "aaa", 44);
        store.updateProduct(5, "bbb", 55);
        store.deleteProduct(6);
        store.deleteProduct(7);
        store.listProducts();
        store.cerrar();

        HibernateUtil.closeSessionFactory();
    }

}
