package com.restaurant.inventory_management.DTO;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO (Data Transfer Object) class to represent the data needed to create a supplier.
 * This class is used to avoid exposing the Supplier entity directly, ensuring better organization and security.
 */
public class SupplierRequest {

    @NotBlank(message="Supplier name cannot be empty") //Name and contact info cannot be null or empty
    private String name;
    @NotBlank(message="Supplier contact info cannot be empty")
    private String contactInfo;

    public SupplierRequest() {}

    /**
     * Constructor with parameters to facilitate the creation of a supplier object
     * @param name Supplier's name
     * @param contactInfo Supplier's contact
     */
    public SupplierRequest(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    //Getters and setters
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
}
