package com.university.uch_university.repository;

import com.university.uch_university.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
