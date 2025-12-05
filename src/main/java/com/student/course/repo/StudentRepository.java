package com.student.course.repo;

import com.student.course.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.emailId = ?1" )
    public Student getStudentByEmailAddress(String emailId);

    @Query(value = "select * from STUDENT s where s.email_address= ?1" , nativeQuery = true)
    public Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "select * from STUDENT s where s.email_address= :emailId" , nativeQuery = true)
    public Student getStudentByEmailAddressByNamedParam(@Param("emailId") String emailId);

   @Modifying
   @Transactional
    @Query(
            value = "UPDATE student SET guardian_name = ?1, guardian_email = ?2, guardian_mobile = ?3 WHERE student_id = ?4",
            nativeQuery = true
    )
    int updateStudentDetails(String guardian_name, String guardian_email, String guardian_mobile, Long studentId);

}
