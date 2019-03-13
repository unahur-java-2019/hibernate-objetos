package net.isetjb.hibernatetutorial2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        Category almacen = new Category("Almacén");
        Category verduleria = new Category("Verdulería");
        Category productosNaturales = new Category("Productos naturales");

        store.add(new Product("Yerba La Cumbrecita 500g", 35, Arrays.asList(almacen), new Brand("La Cumbrecita")));
        store.add(new Product("Almidón de Mandioca Arapeguá 1kg", 80, Arrays.asList(almacen, productosNaturales), new Brand("Arapeguá")));

        store.add(new Product("Uvas rosadas 2kg", 110, Arrays.asList(verduleria, productosNaturales), new Brand("Quinta José")));
    }

    private static void listarProductos(ProductStore store) {
        List<Product> listaProductos = store.all();

        System.out.println("PRODUCTOS");
        for (Product producto : listaProductos) {
            System.out.println("id: " + producto.getId() + ", name: " + producto.getName() + ", price: " + producto.getPrice() + ", brand: " + producto.getBrand().getName());
            System.out.println("categories: " + listaCategorias(producto));
            System.out.println();
        }
    }

    private static String listaCategorias(Product producto) {
        return producto.getCategories()
                .stream()
                .map(category -> category.getName())
                .collect(Collectors.joining(" - "));
    }
}
