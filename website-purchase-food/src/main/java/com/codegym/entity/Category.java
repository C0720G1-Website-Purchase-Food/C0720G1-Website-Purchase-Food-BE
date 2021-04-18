package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<StoreDetail> storeDetails;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<StoreDetail> getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(List<StoreDetail> storeDetails) {
        this.storeDetails = storeDetails;
    }
}
