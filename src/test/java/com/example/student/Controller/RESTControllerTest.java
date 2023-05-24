package com.example.student.Controller;

import com.example.student.Services.StudentService;
import com.example.student.domain.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.student.MotherObject.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(RESTController.class)
class RESTControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    StudentService studentService;

    @Test
    void testCreatNewStudent() throws Exception {
        given(studentService.saveStudent(any(Student.class))).willReturn(anyStudentWithId());
        mockMvc.perform(post("/student")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(anyStudent())))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));

    }

    @Test
    void getStudent() throws Exception {
        mockMvc.perform(get("/student/" + anyStudentId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteByStudentId() throws Exception {
        mockMvc.perform(delete("/student/" + anyStudentId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(studentService).deleteByStudentId(argumentCaptor.capture());

        assertEquals(anyStudentId(), argumentCaptor.getValue());
    }

    @Test
    void testUpdateStudent() throws Exception {
        mockMvc.perform(put("/student/" + anyStudentId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(anyStudent())))
                .andExpect(status().isNoContent());

        verify(studentService).updateStudentById(anyLong(), any(Student.class));
    }

    @Test
    void testPatchStudent() throws Exception {
        mockMvc.perform(patch("/student/" + anyStudentId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(anyStudent())))
                .andExpect(status().isNoContent());

        verify(studentService).patchStudentById(anyString(), any(Student.class));
    }
    @Test
    void testGetStudent() throws Exception {
        mockMvc.perform(get("/student/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(studentService).findAll();
    }
}








