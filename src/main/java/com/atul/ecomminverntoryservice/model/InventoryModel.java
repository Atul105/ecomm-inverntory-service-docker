package com.atul.ecomminverntoryservice.model;

import jakarta.persistence.*;

@Entity
@Table(name="Inventory-DB")
public class InventoryModel {

    @Id
    private String productId;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String productName;

    public InventoryModel(String productId, int quantity, String productName) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
    }

    public InventoryModel(){}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
