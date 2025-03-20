package com.university.uch_university.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.*;

@Entity
public class Meters implements BaseModel{
    @Id
    @GeneratedValue
    UUID id;

    @NotNull
    int number;

    @NotBlank
    String address;

    @Enumerated(EnumType.STRING)
    CounterType counterType;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(mappedBy = "meters")
    List<Readings> readings;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Users users;

    @Override
    public ArrayList<String> getColumns() {
        return new ArrayList<>(Arrays.asList("Идентификатор","Номер счетчика", "Адрес", "Тип счетчика", "Пользователь"));
    }

    @Override
    public LinkedHashMap<String, Object> getNewObject() {
        return new LinkedHashMap<>(){{
           put("number", Map.of("type", "double", "value", 0.0));
           put("address", Map.of("type", "text", "value", ""));
           put("counterType", Map.of("type", "select", "value", List.of(CounterType.values())));
           put("users", Map.of("type", "select-list", "value", new ArrayList<Users>()));
        }};
    }

    @Override
    public ArrayList<Object> getDataAttributes() {
        return new ArrayList<>(Arrays.asList(number, address, counterType, users));
    }

    @Override
    public String getStr() {
        return Double.toString(number);
    }

    @Override
    public String toString() {
        return Double.toString(number);
    }

    enum CounterType {
        COLD_WATER, HOT_WATER
    }

    public Meters(UUID id, int number, String address, CounterType counterType, List<Readings> readings, Users users) {
        this.id = id;
        this.number = number;
        this.address = address;
        this.counterType = counterType;
        this.readings = readings;
        this.users = users;
    }

    public Meters() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CounterType getCounterType() {
        return counterType;
    }

    public void setCounterType(CounterType counterType) {
        this.counterType = counterType;
    }

    public List<Readings> getReadings() {
        return readings;
    }

    public void setReadings(List<Readings> readings) {
        this.readings = readings;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
