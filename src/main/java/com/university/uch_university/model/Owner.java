package com.University.uch_University.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cat> cats = new ArrayList<>();

    public Owner() {}

    public Owner(String name, Clinic clinic, List<Cat> cats) {
        this.name = name;
        this.clinic = clinic;
        this.cats = cats;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    // Геттеры и сеттеры
}
