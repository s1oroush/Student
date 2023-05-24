package com.example.student.Controller;

import com.example.student.Services.StudentService;
import com.example.student.domain.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class RESTController {

    private final StudentService service;

    public RESTController(StudentService service) {
        this.service = service;
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity updateStudentPatchById(@PathVariable("studentId") String studentId, @RequestBody Student student) {
        service.patchStudentById(studentId, student);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") String studentId) {
        return service.fetchStudentByStudentId(studentId);
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {
        return service.findAll();
    }

    @PostMapping()
    public ResponseEntity handlePost(@RequestBody Student student) {
        Student savedStudent = service.saveStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/student/" + savedStudent.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable("id") Long studentId, @RequestBody Student student) {
        service.updateStudentById(studentId, student);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity deleteByStudentId(@PathVariable("studentId") String studentId) {
        service.deleteByStudentId(studentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
