package com.university.uch_university.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "holidays")
public class HolidayModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_holiday",
        joinColumns = @JoinColumn(name = "holiday_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentModel> students;

    public HolidayModel(){

    }

    public HolidayModel(UUID id, String name, List<StudentModel> students) {
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
