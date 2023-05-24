package com.example.student.Services;

import com.example.student.Repositories.StudentRepositories;
import com.example.student.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.example.student.MotherObject.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class StudentServiceImplTest {

    @InjectMocks
    StudentServiceImpl service;
    @Mock
    StudentRepositories repositories;

    @Test
    void findAll() {
        //when
        doReturn(studentsIterable()).when(repositories).findAll();
        //given
        Iterable<Student> students = service.findAll();
        //then courses not empty
        assertTrue(students.iterator().hasNext());
    }


    @Test
    void saveStudent() {
        //when
        doReturn(anyStudent()).when(repositories).save(any());
        //given
        Student student = service.saveStudent(anyStudent());
        // then
        assertEquals(anyStudent(),student);
    }

    @Test
    @DisplayName("for given id exists student for update")
    void updateStudentById() {
        //when
        doReturn(Optional.of(anyStudent())).when(repositories).findById(anyLong());
        //given
        service.updateStudentById(anyId(), anyStudent());
        //then
        verify(repositories, atLeastOnce()).save(any(Student.class));

    }
    @Test
    @DisplayName("for given id not exists student for update")
    void updateStudentByIdNotExist() {
        //when
        doReturn(Optional.empty()).when(repositories).findById(anyLong());
        //given
        //then
        assertThrows(RuntimeException.class, () -> service.updateStudentById(anyId() , anyStudent()));
    }

    @Test
    void fetchStudentByStudentId() {
        //when
        doReturn(anyStudent()).when(repositories).findByStudentId(anyString());
        //given
        Student student = service.fetchStudentByStudentId(anyStudentId());
        //then
        assertNotNull(student);
    }

    @Test
    void deleteByStudentId() {
        //when
        doNothing().when(repositories).deleteByStudentId(anyString());
        //given
        service.deleteByStudentId(anyStudentId());
        //then
        verify(repositories, atLeastOnce()).deleteByStudentId(anyString());
    }

    @Test
    void fetchStudentById(){
        //when
        doReturn(Optional.of(anyStudent())).when(repositories).findById(anyLong());
        //given
        Student student =  service.fetchStudentById(anyId());
        //then
        assertNotNull(student);
    }

    @Test
    @DisplayName("for given id exists student for update")
    void patchStudentById() {
        //when
        doReturn(anyStudent()).when(repositories).findByStudentId(anyString());
        //given
        service.patchStudentById(anyStudentId(), anyStudent());
        //then
        verify(repositories, atLeastOnce()).save(any(Student.class));

    }
    @Test
    @DisplayName("for given id not exists student for update")
    void patchStudentByIdNotExist() {
        //when
        doReturn(Optional.empty()).when(repositories).findById(anyLong());
        //given
        //then
        assertThrows(RuntimeException.class, () -> service.updateStudentById(anyId() , anyStudent()));
    }




}