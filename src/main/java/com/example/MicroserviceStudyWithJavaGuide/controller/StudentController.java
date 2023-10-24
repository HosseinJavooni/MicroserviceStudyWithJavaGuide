package com.example.MicroserviceStudyWithJavaGuide.controller;

import com.example.MicroserviceStudyWithJavaGuide.model.Student;
import com.example.MicroserviceStudyWithJavaGuide.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    @GetMapping("/giveStudentData")
    public Student getStudent(){
        return new Student(1L, "Hossein", "Jabani", "e@1.ocm");
    }
    @GetMapping("/studentList")
    public List<Student> getStudentList(){
        List<Student> studentList = Arrays.asList(
                new Student(1L, "Hossein", "Jabani", "e@2.ocm"),
                new Student(2L, "Mahan", "Jabani", "e@3.ocm"),
                new Student(3L, "Mahnoosh", "Motame", "e@4.ocm")
        );
        return studentList;
    }
    @GetMapping("/giveThis/{id}/{firstName}/{lastName}/{email}")
    public Student giveSpecifiedPersonInPathVariable(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String email){
        return new Student(id, firstName, lastName, email);
    }
    @GetMapping("/giveThis")
    public Student giveSpecifiedStudentInRequestParams(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName, @PathVariable String email){
        return new Student(id, firstName, lastName, email);
    }
    // For Test This api:
    // curl -X POST "http://localhost:8080/student/create" -H "Content-Type:application/json" --data '{"id": 1, "firstName": "Hossein", "lastName":"jabani"}' | json_pp
    // curl -v "http://localhost:8080/student/create" -H "Content-Type:application/json" --data '{"id": 1, "firstName": "Hossein", "lastName":"jabani"}' | json_pp
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student);
        return student;
    }
    // For Test This api:
    // curl -X PUT "http://localhost:8080/student/update/2" -H "Content-Type:application/json" --data '{"id": 398, "firstName":"hossein", "lastName":"jabani"}' | json_pp
    // curl -v  "http://localhost:8080/student/update/2" -H "Content-Type:application/json" --data '{"id": 398, "firstName":"hossein", "lastName":"jabani"}' | json_pp
    @PutMapping("/update/{id}")
    public Student updateStudentSent(@RequestBody Student student, @PathVariable Long id){
        System.out.println(student);
        student.setId(id);
        System.out.println(student);
        return student;
    }
    // For Test This api:
    // curl -X DELETE "http://localhost:8080/student/delete/2" | json_pp
    // curl -v "http://localhost:8080/student/delete/2" | json_pp
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return "Student with id: " + id + " is deleted.";
    }

    // For Test This api:
    // curl -v -X GET "http://localhost:8080/student/customResponse" | json_pp
    // curl -v "http://localhost:8080/student/customResponse" | json_pp
    @GetMapping("/customResponse")
    public ResponseEntity<Student> customizedStudentResponse(){
        return ResponseEntity.accepted()
                .header("Hi", "this is head1")
                .header("server", "myServer")
                .body(new Student(1L, "Hossein", "Jabani", "e@5.com"));
    }
}
