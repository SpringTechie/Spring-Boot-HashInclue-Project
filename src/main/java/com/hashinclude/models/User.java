package com.hashinclude.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "firstName",unique = true,nullable = false)
    private String firstName;
    @Column(name = "lastName",unique = true,nullable = false)
    private String lastName;
    private int age;
}
