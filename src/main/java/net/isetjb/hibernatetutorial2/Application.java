package net.isetjb.hibernatetutorial2;

import java.util.List;

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

        borrarProductos(store);
        insertarProductos(store);
        listarProductos(store);

        store.close();
        HibernateUtil.closeSessionFactory();
    }

    private static void borrarProductos(ProductStore store) {
        store.deleteAll();
    }

    private static void insertarProductos(ProductStore store) {
        store.add(new Product("Yerba La Cumbrecita 500g", 35));
        store.add(new Product("Almidón de Mandioca Arapeguá 1kg", 80));
        store.add(new Product("Uvas rosadas 2kg", 110));
    }

    private static void listarProductos(ProductStore store) {
        List<Product> listaProductos = store.all();

        System.out.println("PRODUCTOS");
        for (Product producto : listaProductos) {
            System.out.println("id: " + producto.getId() + ", name: " + producto.getName() + ", price: " + producto.getPrice());
        }
    }

}
