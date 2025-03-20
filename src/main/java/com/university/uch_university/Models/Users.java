package com.university.uch_university.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.*;

import static javax.swing.UIManager.put;


@Entity
@Table(name = "users")
public class Users implements BaseModel{
    @Id
    @GeneratedValue
    UUID id;

    @NotBlank(message = "Имя пользователя не должно быть пустым")
    String FIO;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Profile profile;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Meters meters;

    public Users(UUID id, String FIO, Profile profile, Meters meters) {
        this.id = id;
        this.FIO = FIO;
        this.profile = profile;
        this.meters = meters;
    }

    public Users() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Meters getMeters() {
        return meters;
    }

    public void setMeters(Meters meters) {
        this.meters = meters;
    }

    @Override
    public ArrayList<String> getColumns() {
        return new ArrayList<>(Arrays.asList("Идентификатор", "ФИО", "Профиль"));
    }

    @Override
    public LinkedHashMap<String, Object> getNewObject() {
        return new LinkedHashMap<>(){{
           put("FIO", Map.of("type", "text", "value", ""));
           put("profile", Map.of("type", "select-list", "value", new ArrayList<Profile>()));
        }};
    }

    @Override
    public ArrayList<Object> getDataAttributes() {
        return new ArrayList<>(Arrays.asList(FIO, profile.username));
    }

    @Override
    public String getStr() {
        return FIO;
    }

    @Override
    public String toString() {
        return FIO;
    }
}