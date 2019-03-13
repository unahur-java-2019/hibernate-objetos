package net.isetjb.hibernatetutorial2;

import javax.persistence.*;
import java.util.List;

/**
 * Category class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
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

}
