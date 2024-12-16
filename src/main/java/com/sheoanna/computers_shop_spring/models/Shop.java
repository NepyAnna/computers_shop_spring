package com.sheoanna.computers_shop_spring.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    private Long id_shop;

    @Column(name = "name_store", nullable = false, length = 100)
    private String nameStore;

    @Column(name = "id_tax", nullable = false, length = 100)
    private int idTax;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_owner", nullable = true)
    @JsonIgnore
    private Owner owner;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Computer> computers = new ArrayList<Computer>();

    public Shop() {}

    public Shop(String name, Owner owner, int id){
        this.nameStore = name;
        this.owner = owner;
        this.idTax = id;
    }

    public Long getId_shop() {
        return id_shop;
    }

    public String getStoreName() {
        return nameStore;
    }

    public int getTaxID() {
        return idTax;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Computer> getComputer() {
        return computers;
    }

    public void setId_shop(Long id_shop) {
        this.id_shop = id_shop;
    }

    public void setStoreName(String name) {
        this.nameStore = name;
    }

    public void setTaxID(int taxID) {
        this.idTax = taxID;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setComputers(List<Computer> list) {
        this.computers = list;
    }
}
