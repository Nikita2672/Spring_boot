package com.example.spring_boot.services.implementation;

import com.example.spring_boot.model.Person;
import com.example.spring_boot.repositories.PeopleRepository;
import com.example.spring_boot.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public UserServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Person findOneByUsername(String login) {
        return peopleRepository.findByUsername(login).orElse(null);
    }

    @Override
    public Person findById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public boolean checkLogin(String login) {
        return findOneByUsername(login) == null; // if true that means login is unique
    }

    @Override
    @Transactional
    public void addUser(Person person) {
        peopleRepository.save(person);
    }
}
