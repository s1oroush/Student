package com.example.student.BootStrap;

import com.example.student.Repositories.StudentRepositories;
import com.example.student.domain.Student;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class BootStrap implements CommandLineRunner {

    private final StudentRepositories studentRepositories;


    @Override
    public void run(String... args) throws Exception {
        Student soroush = new Student();
        soroush.setName("soroush");
        soroush.setStudentId("900606217");

        Student roozbe = new Student();
        roozbe.setName("roozbe");
        roozbe.setStudentId("970243061");

        Student pegah = new Student();
        pegah.setName("pegah");
        pegah.setStudentId("930251412");

        Student reza = new Student();
        reza.setName("reza");
        reza.setStudentId("960251215");

        Student ali = new Student();
        ali.setName("ali");
        ali.setStudentId("930202021");

        Student mohammad = new Student();
        mohammad.setName("mohammad");
        mohammad.setStudentId("910214151");

        Student soroushSaved = studentRepositories.save(soroush);
        Student roozbeSaved = studentRepositories.save(roozbe);
        Student pegahSaved = studentRepositories.save(pegah);
        Student rezaSaved = studentRepositories.save(reza);
        Student aliSaved = studentRepositories.save(ali);
        Student mohammadSaved = studentRepositories.save(mohammad);

        studentRepositories.save(roozbeSaved);
        studentRepositories.save(soroushSaved);
        studentRepositories.save(pegahSaved);
        studentRepositories.save(rezaSaved);
        studentRepositories.save(aliSaved);
        studentRepositories.save(mohammadSaved);

        System.out.println(" IN BootStrap");
        System.out.println("Student count: "+ studentRepositories.count());
    }
}
