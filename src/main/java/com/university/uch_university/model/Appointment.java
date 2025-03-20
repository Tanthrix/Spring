package com.University.uch_University.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToMany
    @JoinTable(
            name = "appointment_treatment",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    private List<Treatment> treatments = new ArrayList<>();

    public Appointment() {}

    public Appointment(LocalDate date, LocalTime time, Cat cat, Vet vet, List<Treatment> treatments) {
        this.date = date;
        this.time = time;
        this.cat = cat;
        this.vet = vet;
        this.treatments = treatments;
    }

    // Геттеры и сеттеры
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
