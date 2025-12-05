package com.student.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
   private String firstName;
   private String lastName;
   @Column(name="email_address" , unique = true ,nullable = false)
   private String emailId;
   @Embedded
   private Guardian guardian;
}
