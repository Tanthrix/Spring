package com.university.uch_university.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.*;

@Entity
public class Consuption implements BaseModel{
    @Id
    @GeneratedValue
    UUID id;

    Double count;

    Double volume;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    Tariffs tariffs;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Readings readings;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Payments payments;

    public Consuption() {
    }

    public Consuption(UUID id, Double count, Double volume, Tariffs tariffs, Readings readings, Payments payments) {
        this.id = id;
        this.count = count;
        this.volume = volume;
        this.tariffs = tariffs;
        this.readings = readings;
        this.payments = payments;
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

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Tariffs getTariffs() {
        return tariffs;
    }

    public void setTariffs(Tariffs tariffs) {
        this.tariffs = tariffs;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    @Override
    public ArrayList<String> getColumns() {
        return new ArrayList<>(Arrays.asList("Идентификатор", "Стоимость", "Объем", "Тариф", "Показатель счетчика", "Оплата"));
    }

    @Override
    public LinkedHashMap<String, Object> getNewObject() {
        return new LinkedHashMap<>(){{
           put("count", Map.of("type", "number", "value", 0));
           put("volume", Map.of("type", "number", "value", 0));
           put("tariffs", Map.of("type", "select-list", "value", new ArrayList<Tariffs>()));
           put("readings", Map.of("type", "select-list", "value", new ArrayList<Readings>()));
           put("payments", Map.of("type", "select-list", "value", new ArrayList<Payments>()));
        }};
    }

    @Override
    public ArrayList<Object> getDataAttributes() {
        return new ArrayList<>(Arrays.asList(count, volume, tariffs, readings, payments));
    }

    @Override
    public String getStr() {
        return volume.toString();
    }

    @Override
    public String toString() {
        return volume.toString();
    }
}
