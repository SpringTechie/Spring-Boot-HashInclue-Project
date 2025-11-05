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

    @Column(name = "name",unique = true,nullable = false)
    private String firstName;
    private String lastName;
    private int age;
}
