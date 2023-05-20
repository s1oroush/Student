package com.example.student.Controller;

import com.example.student.Services.StudentService;
import com.example.student.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class RESTController {

    private StudentService service;

    public RESTController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") long id){
        return service.fetchStudentById(id);
    }
}
