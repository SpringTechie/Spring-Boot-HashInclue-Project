package com.hashinclude.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "firstName",unique = true,nullable = false)
    private String firstName;
    @Column(name = "lastName",unique = true,nullable = false)
    private String lastName;
    private int age;
}
