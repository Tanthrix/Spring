package com.university.uch_university.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.*;

@Entity
public class Tariffs implements BaseModel {

    @Id
    @GeneratedValue
    UUID id;

    @NotBlank
    String waterType;

    @NotBlank
    String title;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(mappedBy = "tariffs")
    List<Consuption> consuptions;

    public Tariffs() {
    }

    public Tariffs(UUID id, String waterType, String title, List<Consuption> consuptions) {
        this.id = id;
        this.waterType = waterType;
        this.title = title;
        this.consuptions = consuptions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Consuption> getConsuptions() {
        return consuptions;
    }

    public void setConsuptions(List<Consuption> consuptions) {
        this.consuptions = consuptions;
    }

    @Override
    public ArrayList<String> getColumns() {
        return new ArrayList<>(Arrays.asList("Идентификатор", "Тип воды", "Название"));
    }

    @Override
    public LinkedHashMap<String, Object> getNewObject() {
        return new LinkedHashMap<>(){{
           put("waterType", Map.of("type", "text", "value", ""));
           put("title", Map.of("type", "text", "value", ""));
        }};
    }

    @Override
    public ArrayList<Object> getDataAttributes() {
        return new ArrayList<>(Arrays.asList(waterType, title));
    }

    @Override
    public String getStr() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
