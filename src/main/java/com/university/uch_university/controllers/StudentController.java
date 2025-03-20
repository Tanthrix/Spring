package com.university.uch_university.controllers;

import com.university.uch_university.model.StudentModel;
import com.university.uch_university.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("students", studentService.findAllStudents());
            return "studentList";
        }
        studentService.addStudent(student);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result) {
        studentService.updateStudent(student);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("students", studentService.findStudentById(id));
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }
}
