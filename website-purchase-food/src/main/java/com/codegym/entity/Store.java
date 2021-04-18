package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String phone;
    @Column(columnDefinition = "time")
    private String timeStart;
    @Column(columnDefinition = "time")
    private String timeEnd;
    private String preparationTime;
    @Column(columnDefinition = "text")
    private String image;

    @JsonBackReference(value = "account")
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    @JsonBackReference
    @OneToMany(mappedBy = "store")
    private List<Product> products;

    @JsonBackReference
    @OneToMany(mappedBy = "store")
    private List<StoreDetail> storeDetails;

    public Store() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<StoreDetail> getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(List<StoreDetail> storeDetails) {
        this.storeDetails = storeDetails;
    }
}
