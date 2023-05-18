package com.example.student.Repositories;

import com.example.student.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositories extends CrudRepository<Student , Long> {
}
