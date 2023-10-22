package com.example.MicroserviceStudyWithJavaGuide.controller;

import com.example.MicroserviceStudyWithJavaGuide.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/giveStudentData")
    public Student getStudent(){
        return new Student(1, "Hossein", "Jabani");
    }
    @GetMapping("/studentList")
    public List<Student> getStudentList(){
        List<Student> studentList = Arrays.asList(
                new Student(1, "Hossein", "Jabani"),
                new Student(2, "Mahan", "Jabani"),
                new Student(3, "Mahnoosh", "Motame")
        );
        return studentList;
    }
    @GetMapping("/giveThis/{id}/{firstName}/{lastName}")
    public Student giveSpecifiedPersonInPathVariable(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName ){
        return new Student(id, firstName, lastName);
    }
    @GetMapping("/giveThis")
    public Student giveSpecifiedStudentInRequestParams(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
    // For Test This api:
    // curl -X POST "http://localhost:8080/student/create" -H "Content-Type:application/json" --data '{"id": 1, "firstName": "Hossein", "lastName":"jabani"}'
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student);
        return student;
    }
    // For Test This api:
    // curl -X PUT "http://localhost:8080/student/update/2" -H "Content-Type:application/json" --data '{"id": 398, "firstName":"hossein", "lastName":"jabani"}'
    @PutMapping("/update/{id}")
    public Student updateStudentSent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student);
        student.setId(id);
        System.out.println(student);
        return student;
    }
    // For Test This api:
    // curl -X DELETE "http://localhost:8080/student/delete/2"
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return "Student with id: " + id + " is deleted.";
    }
    // For Test This api:
    // curl -v -X GET "http://localhost:8080/student/customResponse"
    @GetMapping("/customResponse")
    public ResponseEntity<Student> customizedStudentResponse(){
        return ResponseEntity.accepted()
                .header("Hi", "this is head1")
                .header("server", "myServer")
                .body(new Student(1, "Hossein", "Jabani"));
    }
}
