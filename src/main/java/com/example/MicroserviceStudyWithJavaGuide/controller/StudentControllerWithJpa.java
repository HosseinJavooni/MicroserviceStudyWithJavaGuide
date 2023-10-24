package com.example.MicroserviceStudyWithJavaGuide.controller;

import com.example.MicroserviceStudyWithJavaGuide.model.Student;
import com.example.MicroserviceStudyWithJavaGuide.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("student/jpa")
public class StudentControllerWithJpa {
    StudentService studentService;
    // For Test This api:
    // curl -vX POST "http://localhost:8080/student/jpa/create" -H "Content-Type:application/json" --data '{"firstName":"hossein", "lastName":"jabani", "email": "h.ja@gmail.com"}' | json_pp
    // curl -v "http://localhost:8080/student/jpa/create" -H "Content-Type:application/json" --data '{"firstName":"hossi", "lastName":"jabani", "email": "h.ja@gmail.com"}' | json_pp
    @PostMapping("/create")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity(studentService.createStudent(student), HttpStatus.CREATED);
    }
    // For Test This api:
    // curl -v "http://localhost:8080/student/jpa/find/2" | json_pp
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Optional<Student> student = studentService.findStudentById(id);
        return student.map(value -> ResponseEntity.ok().body(value)).orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    // For Test This api:
    // curl -v "http://localhost:8080/student/jpa/findAll" | json_pp
    @GetMapping("/findAll")
    public ResponseEntity<List<Student>> getAllStudentList(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
