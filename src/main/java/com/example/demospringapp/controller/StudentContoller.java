package com.example.demospringapp.controller;

import com.example.demospringapp.model.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentContoller {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "John", "A+"),
            new Student(1, "Joseph", "B-")
    ));

    @GetMapping("/students")
    List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    boolean addStudent(@RequestBody Student student) {
        return students.add(student);
    }

    @DeleteMapping("/student/{id}")
    boolean deleteStudentById(@PathVariable("id") int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}