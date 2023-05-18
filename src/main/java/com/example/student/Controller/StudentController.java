package com.example.student.Controller;

import com.example.student.Services.StudentService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Data
@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/Student")
    public String getStudent(Model model){
        model.addAttribute("LIST", studentService.findAll());
        return "Student";
    }
}
