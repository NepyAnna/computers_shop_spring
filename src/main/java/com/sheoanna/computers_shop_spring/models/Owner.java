package com.sheoanna.computers_shop_spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_owner")
    private Long id_owner;

    @Column(name = "name_owner", nullable = false, length = 100)
    private String nameOwner;

    public Owner() {}

    public Owner(String name) {
        this.nameOwner = name;
    }

    public Long getId_owner() {
        return id_owner;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setId_owner(Long id_owner) {
        this.id_owner = id_owner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }
}
