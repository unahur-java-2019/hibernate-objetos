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
        store.addProduct(new Product("Yerba La Cumbrecita 500g", 35));
        store.addProduct(new Product("Almidón de Mandioca Arapeguá 1kg", 80));
        store.addProduct(new Product("Uvas rosadas 2kg", 110));
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
