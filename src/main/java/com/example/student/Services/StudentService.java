package com.example.student.Services;

import com.example.student.domain.Student;

public interface StudentService {


    Iterable<Student> findAll();

    Student fetchStudentById(long id);

    Student saveStudent(Student student);

    void updateStudentById(Long studentId, Student student);

    Student fetchStudentByStudentId(String studentId);

    void deleteByStudentId(String studentId);

    void patchStudentById(String  studentId, Student student);
}
