package com.fvillegasos.shop_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BRAND")
public class BrandEntity {

    @Id
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    @Column(name = "NAME", nullable = false)
    private String name;

    public BrandEntity() {
    }

    public BrandEntity(Long brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
