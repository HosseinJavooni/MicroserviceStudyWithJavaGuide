package com.example.MicroserviceStudyWithJavaGuide.repository;

import com.example.MicroserviceStudyWithJavaGuide.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
