package com.example.student.Services;

import com.example.student.Repositories.StudentRepositories;
import com.example.student.domain.Student;
import lombok.Builder;
import org.camunda.commons.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

import static java.lang.Long.parseLong;

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
            existing.setStudentId(student.getStudentId());
            studentRepositories.save(existing);
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public Student fetchStudentByStudentId(String studentId) {
        Student student=studentRepositories.findByStudentId(studentId);
        return student;
    }

    @Override
    public void deleteByStudentId(String studentId) {
        studentRepositories.deleteByStudentId(studentId);
    }

    @Override
    public void patchStudentById(String  studentId, Student student) {
        Student existing = studentRepositories.findByStudentId(studentId);
        if(StringUtils.hasText(student.getName())){
            existing.setName(student.getName());
        }
        studentRepositories.save(saveStudent(student));

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
                .studentId(student.getStudentId())
                .name(student.getName())
                .build();

        studentRepositories.save(savedStudent);
        return savedStudent;
    }
}
