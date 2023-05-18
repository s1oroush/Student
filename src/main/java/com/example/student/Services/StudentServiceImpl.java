package com.example.student.Services;

import com.example.student.Repositories.StudentRepositories;
import com.example.student.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositories studentRepositories;

    public StudentServiceImpl(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepositories.findAll();
    }
}
