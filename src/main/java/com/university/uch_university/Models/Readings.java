package com.university.uch_university.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.*;

@Entity
public class Readings implements BaseModel{

    @Id
    @GeneratedValue
    UUID id;

    Double count;

    @NotBlank
    String date;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    Meters meters;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Consuption consuption;


    @Override
    public ArrayList<String> getColumns() {
        return new ArrayList<>(Arrays.asList("Идентификатор","Значение счетчика", "Дата показания", "Счетчик"));
    }

    @Override
    public LinkedHashMap<String, Object> getNewObject() {
        return new LinkedHashMap<>(){{
           put("count", Map.of("type", "double", "value", 0.0));
           put("date", Map.of("type", "date", "value", ""));
           put("meters", Map.of("type", "select-list", "value", new ArrayList<Meters>()));
        }};
    }

    @Override
    public ArrayList<Object> getDataAttributes() {
        return new ArrayList<>(Arrays.asList(count,date,meters));
    }

    @Override
    public String getStr() {
        return meters.getStr();
    }

    @Override
    public String toString() {
        return meters.getStr();
    }

    public Readings() {
    }

    public Readings(UUID id, Double count, String date, Meters meters, Consuption consuption) {
        this.id = id;
        this.count = count;
        this.date = date;
        this.meters = meters;
        this.consuption = consuption;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Meters getMeters() {
        return meters;
    }

    public void setMeters(Meters meters) {
        this.meters = meters;
    }

    public Consuption getConsuption() {
        return consuption;
    }

    public void setConsuption(Consuption consuption) {
        this.consuption = consuption;
    }
}
