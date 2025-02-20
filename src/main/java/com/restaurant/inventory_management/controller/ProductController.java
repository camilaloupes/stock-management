package com.restaurant.inventory_management.controller;

import com.restaurant.inventory_management.DTO.ProductRequest;
import com.restaurant.inventory_management.models.Product;
import com.restaurant.inventory_management.services.ProductService;
import com.restaurant.inventory_management.models.Supplier;
import com.restaurant.inventory_management.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Define the base URL
public class ProductController {

    private final ProductService productService;
    private final SupplierService supplierService;
    @Autowired
    public ProductController( ProductService productService, SupplierService supplierService) { //Constructor to inject the service
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @PostMapping //POST method to create a new product
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) {
        // Extract product details from the request
        Product newProduct = new Product(
                request.getName(),
                request.getBuyingPrice(),
                request.getQuantity(),
                request.getCategory(),
                request.getUnit()
        );
        //Retrieve the supplier by ID
        Supplier supplier = supplierService.getSupplierById(request.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        // Add the supplier to the product
        newProduct.addSupplier(supplier);
        //Save the product in the database
        Product savedProduct = productService.addProduct(newProduct);
        return ResponseEntity.ok(savedProduct);
    }


    @GetMapping //GET method to retrieve all products
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}") //GET method to retrieve a specific product by ID
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Retrieve the product by ID and throws an exception if not found
        Product product = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}") //PUT method to update a specific product by ID
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/{id}") //DELETE method to delete a specific product by ID
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
