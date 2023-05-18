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
        soroush.setStudentID("900606217");

        Student roozbe = new Student();
        roozbe.setName("roozbe");
        roozbe.setStudentID("970243061");

        Student pegah = new Student();
        pegah.setName("pegah");
        pegah.setStudentID("930251412");

        Student soroushSaved = studentRepositories.save(soroush);

        Student roozbeSaved = studentRepositories.save(roozbe);

        Student pegahSaved = studentRepositories.save(pegah);

        studentRepositories.save(roozbeSaved);
        studentRepositories.save(soroushSaved);
        studentRepositories.save(pegahSaved);

        System.out.println(" IN BootStrap");
        System.out.println("Student count: "+ studentRepositories.count());
    }
}
