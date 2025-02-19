package com.restaurant.invetory_management.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactInfo;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>(); // Initialize the products set with an empty HashSet<>

public Supplier() {
    // Default constructor
}

public Supplier(String name, String contactInfo) {
    this.name = name;
    this.contactInfo = contactInfo;
}

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
    public void setProducts (Set<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
        product.setSupplier(this);
        products.add(product);
    }
    public void removeProduct(Product product) {
        product.setSupplier(null);
        products.remove(product);
    }
}
