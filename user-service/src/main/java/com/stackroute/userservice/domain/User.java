package com.stackroute.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private  String email;
    @Column(name = "password")
    private String password;
    @Column(name ="confirmPassword")
    private  String confirmPassword;
    @Column(name = "enable")
    private  boolean enable;
    @Column(name = "role")
    private String role;
    @Column(name = "date")
    private Date date;
}
