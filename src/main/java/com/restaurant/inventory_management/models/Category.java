package com.restaurant.inventory_management.models;

public enum Category {
    CLEANING_DISPOSABLE ("Cleaning & Disposable"),
    BEEF ("Beef"),
    FRUITS_VEGES ("Fruits & Vegetables"),
    DRINKS ("Drinks"),
    PORK ("Pork"),
    FISH ("Fish"),
    CHICKEN ("Chicken"),
    DAIRY ("Dairy"),
    PASTA("Pasta"),
    NON_PERISHABLE("Non-perishable"),
    COLD_CUTS("Cold cuts");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
