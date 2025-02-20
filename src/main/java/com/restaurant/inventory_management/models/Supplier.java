package com.restaurant.inventory_management.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//This is a database entity class.
@Entity
public class Supplier {
    //The id is generated automatically by the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactInfo;
    //One Supplier can have many Products. It initializes the products set with an empty HashSet<>.
    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products = new HashSet<>(); // Initialize the products set with an empty HashSet<>

    // Default constructor
    public Supplier() {

    }

    public Supplier(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.products = new HashSet<>();
    }

    // Getters and setters to access and modify supplier properties.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    //Methods to add and remove products from the supplier.
    public void addProduct(Product product) {
        this.products.add(product);
        product.getSuppliers().add(this);
    }

    public void removeProduct(Product product) {
      this.products.remove(product);
      product.getSuppliers().remove(this);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
