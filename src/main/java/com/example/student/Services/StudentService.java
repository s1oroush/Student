package com.example.student.Services;

import com.example.student.domain.Student;

public interface StudentService {


    Iterable<Student> findAll();

    Student fetchStudentById(long id);

    Student saveStudent(Student student);

    void updateStudentById(Long studentId, Student student);
}
