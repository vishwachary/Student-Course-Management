package com.student.course.configure;

import com.student.course.entity.Guardian;
import com.student.course.entity.Student;
import com.student.course.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoad implements CommandLineRunner {

    StudentRepository repo;
    @Autowired
    public DataLoad(StudentRepository studentRepository) {
        this.repo = studentRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            repo.save(
                    Student.builder()
                            .firstName("Mahesh")
                            .lastName("Varanasi")
                            .emailId("mahesh@example.com")
                           // .guardianName("Vishwa")
                          //  .guardianMobile("99999999")
                           // .guardianEmail("vishwa@gmail.com")
                            .build()
            );
            repo.save(
                    Student.builder()
                            .firstName("Rahul")
                            .lastName("kumar")
                            .emailId("kumar@example.com")
                            .guardian(Guardian.builder()
                                    .name("Rakesh")
                                    .email("rakesh@gmail.com")
                                    .mobile("0909098")
                                    .build())
                            // .guardianName("Vishwa")
                            //  .guardianMobile("99999999")
                            // .guardianEmail("vishwa@gmail.com")
                            .build()
            );
        }catch (Exception e){
            System.out.println("Duplicate detected, skipping...");
        }

    }
}
