package com.elsa.RESTdemo.rest;

import com.elsa.RESTdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data
    // ... only once!
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poorina", "Patel"));
        theStudents.add(new Student("Ron", "Wensley"));
        theStudents.add(new Student("Harry", "Potter"));

    }
    // define endpoint for "/students"
    // return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }
    // define endpoint or "/students/{studentId}"
    // - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the studentId again list siz
        if (studentId >= theStudents.size() || studentId < 0){

            throw new StudentNotFoundException("Student id not found" + studentId);
        }

        return theStudents.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}












