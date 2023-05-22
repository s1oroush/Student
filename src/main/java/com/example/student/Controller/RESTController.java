package com.example.student.Controller;

import com.example.student.Services.StudentService;
import com.example.student.domain.Student;
import jakarta.ws.rs.GET;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class RESTController {

    private final StudentService service;

    public RESTController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}" )
    public Student getStudent(@PathVariable("id") long id){
        return service.fetchStudentById(id);
    }

    @GetMapping ("/all")
    public Iterable<Student> getAllStudents(){
        return service.findAll();
    }

    @PostMapping()
    public ResponseEntity handlePost (@RequestBody Student student){
        Student savedStudent = service.saveStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/student/"+savedStudent.getId().toString());

         return new ResponseEntity(headers ,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById (@PathVariable("id")Long studentId, @RequestBody Student student) {
        service.updateStudentById(studentId, student);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }




}
