package com.student.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.student.course"})
public class StudentCourseManager {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseManager.class, args);
    }

}
