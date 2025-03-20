package com.university.uch_university.service;

import com.university.uch_university.model.StudentModel;
import com.university.uch_university.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public InMemoryStudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudents() {
        return studentRepository.findAll(Sort.by("id"));
    }

    @Override
    public StudentModel findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentModel addStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }

    }
}
