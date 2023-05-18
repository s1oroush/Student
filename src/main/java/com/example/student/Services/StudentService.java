package com.example.student.Services;

import com.example.student.domain.Student;

public interface StudentService {

    Iterable<Student> findAll();
}
