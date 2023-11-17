package com.example.MicroserviceStudyWithJavaGuide.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "SEQUENCE_TEST"/*, initialValue = 30 , allocationSize = 10*/)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_TEST")
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String LastName;
    @Column(nullable = false)
    private String email;
}