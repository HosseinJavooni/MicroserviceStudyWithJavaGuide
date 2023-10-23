package com.example.MicroserviceStudyWithJavaGuide.service.impl;

import com.example.MicroserviceStudyWithJavaGuide.model.Student;
import com.example.MicroserviceStudyWithJavaGuide.repository.StudentRepository;
import com.example.MicroserviceStudyWithJavaGuide.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
