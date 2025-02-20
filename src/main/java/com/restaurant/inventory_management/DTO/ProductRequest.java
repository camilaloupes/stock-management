package com.restaurant.inventory_management.DTO;

import com.restaurant.inventory_management.models.Category;
import com.restaurant.inventory_management.models.Unit;

public class ProductRequest {
    private String name;
    private int quantity;
    private Unit unit;
    private Category category;
    private double buyingPrice;
    private Long supplierId;

    //Default constructor
    public ProductRequest() {
    }

    public ProductRequest(String name, int quantity, Unit unit, Category category, double buyingPrice, Long supplierId) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
        this.buyingPrice = buyingPrice;
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
