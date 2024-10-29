package com.fvillegasos.shop_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "NAME", nullable = false)
    private String name;

    public ProductEntity() {
    }

    public ProductEntity(Long productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
