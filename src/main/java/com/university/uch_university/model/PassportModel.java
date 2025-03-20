package com.university.uch_university.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "passports")
public class PassportModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String series;
    private String number;

    @OneToOne(optional = false, mappedBy = "passport")
    private StudentModel owner;

    public PassportModel(){

    }

    public PassportModel(UUID id, String series, String number, StudentModel owner) {
        this.id = id;
        this.series = series;
        this.number = number;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public String getSeries() {
        return series;
    }

    public String getNumber() {
        return number;
    }

    public StudentModel getOwner() {
        return owner;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(StudentModel owner) {
        this.owner = owner;
    }
}
