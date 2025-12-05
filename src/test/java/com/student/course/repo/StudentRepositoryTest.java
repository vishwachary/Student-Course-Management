package com.student.course.repo;

import com.student.course.entity.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;



    @Test
    public void printAllStudents() {
        studentRepository.findAll().forEach(System.out::println);
    }


    @Test
    public void printStudentByFirstName() {
        studentRepository.findByFirstName("Rahul").forEach(System.out::println);
    }

    @Test
    public void getAndPrintStudentEmail() {
        Student studentByEmailAddress =
                studentRepository.getStudentByEmailAddress("kumar@example.com");
        System.out.println(studentByEmailAddress.getEmailId());
    }

    @Test
    public void getStudentByEmailAddressNative()
    {
        Student studentByEmailAddressNative = studentRepository.getStudentByEmailAddressNative("kumar@example.com");
        assertNotNull(studentByEmailAddressNative);
        System.out.println("from getStudentByEmailAddressNative " + studentByEmailAddressNative.getEmailId());
    }

    @Test
    public void getStudentByEmailAddressNamedParam()
    {
        Student studentByEmailAddressNative = studentRepository.getStudentByEmailAddressByNamedParam("kumar@example.com");
        assertNotNull(studentByEmailAddressNative);
        System.out.println("from getStudentByEmailAddressNamedParam " + studentByEmailAddressNative.getEmailId());
    }


    @Test
    public void testUpdateStudentDetails()
    {
        studentRepository.updateStudentDetails("shankar","shankar@gmail.com","898978786", 4L);

    }

}