package com.example.spring_boot.services.interfaces;

import com.example.spring_boot.model.Person;

public interface UserService {
    Person findOneByUsername(String login);
    Person findById(int id);
    boolean checkLogin(String login);
    void addUser(Person person);
}
