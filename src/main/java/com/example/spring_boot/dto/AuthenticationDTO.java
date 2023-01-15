package com.example.spring_boot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationDTO {

    @NotEmpty(message = "login mustn't be empty")
    @Size(min = 4, max = 100, message = "login must be between 4 and 100 characters")
    private String username;

    @NotEmpty(message = "login mustn't be empty")
    @Size(min = 4, max = 100, message = "login must be between 4 and 100 characters")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
