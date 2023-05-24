package com.example.student;

import com.example.student.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class MotherObject {
    public static String DUMMY = "dummy";

    public static Iterable<Student> studentsIterable() {
        List<Student> students = new ArrayList<>();
        students.add(anyStudent());
        students.add(anyStudent());
        students.add(anyStudent());
        return students;
    }

    public static Student anyStudent() {
        return Student.builder()
                .name(DUMMY)
                .studentId(DUMMY)
                .build();
    }

    public static Student anyStudentWithId() {
        return Student.builder()
                .id(1L)
                .name(DUMMY)
                .studentId(DUMMY)
                .build();
    }

    public static long anyId() {
        return 1L;
    }

    public static String anyStudentId() {
        return "1";
    }

}