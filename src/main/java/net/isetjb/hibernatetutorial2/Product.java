package net.isetjb.hibernatetutorial2;

import javax.persistence.*;
import java.util.List;

/**
 * Product class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Product_Category",
        joinColumns = {@JoinColumn(name = "product_id")},
        inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;

    public Product(String name, int price, List<Category> categories, Brand brand) {
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.brand = brand;
    }

    public Product() {
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}


