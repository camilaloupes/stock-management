package com.restaurant.inventory_management.DTO;

import com.restaurant.inventory_management.models.MovementType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class StockRequest {
    @NotNull(message = "Product ID is required.") //Id of the product cannot be null or empty
    private Long productId;

    @Min(value = 1, message = "Quantity must be at least 1.") //Quantity must be at least 1
    private int quantity;

    @NotNull(message = "Movement type is required.") //Movement type cannot be null or empty
    private MovementType movementType;

    public StockRequest() {}

    public StockRequest(Long productId, int quantity, MovementType movementType) {
        this.productId = productId;
        this.quantity = quantity;
        this.movementType = movementType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
