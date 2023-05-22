package com.example.student.Services;

import com.example.student.Repositories.StudentRepositories;
import com.example.student.domain.Student;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositories studentRepositories;

    public StudentServiceImpl(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }


    @Override
    public void updateStudentById(Long studentId, Student student) {
        Optional<Student> optionalStudent = studentRepositories.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student existing = optionalStudent.get();
            existing.setName(student.getName());
            existing.setStudentID(student.getStudentID());
            studentRepositories.save(existing);
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepositories.findAll();
    }

    @Override
    public Student fetchStudentById(long id) {
        return studentRepositories.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        Student savedStudent = Student.builder()
                .studentID(student.getStudentID())
                .name(student.getName())
                .build();

        studentRepositories.save(savedStudent);
        return savedStudent;
    }
}
