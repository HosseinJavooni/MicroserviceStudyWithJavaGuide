package com.example.MicroserviceStudyWithJavaGuide.service;

import com.example.MicroserviceStudyWithJavaGuide.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    Optional<Student> findStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Student student);

    boolean deleteStudent(Student student);
}
