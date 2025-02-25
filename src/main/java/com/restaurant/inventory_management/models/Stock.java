package com.restaurant.inventory_management.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //A product can have several movements in the stock.
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity; //Amount of movement(positive for incoming, negative for outgoing)

    @Enumerated (EnumType.STRING)
    private MovementType movementType;
    protected LocalDateTime movementDate; //Date of the movement

    public Stock() {}

    public Stock(Product product, int quantity, MovementType movementType) {
        this.product = product;
        this.quantity = quantity;
        this.movementType = movementType;
        this.movementDate = LocalDateTime.now(); //Current date
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }
}
