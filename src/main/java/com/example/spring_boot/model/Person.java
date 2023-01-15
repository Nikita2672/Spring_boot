package com.example.spring_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "login mustn't be empty")
    @Size(min = 4, max = 100, message = "login must be between 4 and 100 characters")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "password mustn't be empty")
    @Size(min = 4, max = 100, message = "password must be between 4 and 100 characters")
    private String password;

    public Person() {
    }

    public Person(String username) {
        this.username = username;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Person(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{"
                + "                             id=" + id
                + ",                             login='" + username + '\''
                + ",                             password='" + password + '\''
                + '}';
    }
}
