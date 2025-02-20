package com.restaurant.inventory_management.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//This is a database entity class.
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //The id will be auto-generated.
    private Long id;
    private String name;
    private double buyingPrice;
    private int quantity;
    @Enumerated (EnumType.STRING)
    private Category category;
    @Enumerated (EnumType.STRING)
    private Unit unit;

    //
    @ManyToMany
    @JoinTable(name = "product_supplier",
               joinColumns = @JoinColumn(name = "product_id"),
               inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    public Product() {
    // Default constructor
    }
    public Product(String name, double buyingPrice, int quantity, Category category, Unit unit) {
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.quantity = quantity;
        this.category = category;
        this.unit = unit;
        this.suppliers = new HashSet<>();

    }

    // Getters and setters to access product properties.
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

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        supplier.getProducts().add(this);
    }
    public void removeSupplier(Supplier supplier) {
        suppliers.remove(supplier);
        supplier.getProducts().remove(this);
    }
    public Set<Supplier> getSuppliers() {return suppliers;}

    public void setSuppliers(Set<Supplier> suppliers) {this.suppliers = suppliers;}
}
