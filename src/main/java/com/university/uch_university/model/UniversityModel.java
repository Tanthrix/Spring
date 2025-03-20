package com.university.uch_university.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "universities")
public class UniversityModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @OneToMany (mappedBy = "university", cascade = CascadeType.ALL)
    private List<StudentModel> students;

    public UniversityModel(){

    }

    public UniversityModel(UUID id, String name, List<StudentModel> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }
}
