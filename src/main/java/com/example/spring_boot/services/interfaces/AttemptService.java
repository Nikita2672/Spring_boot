package com.example.spring_boot.services.interfaces;

import com.example.spring_boot.model.Attempt;
import com.example.spring_boot.model.Person;

import java.util.List;

public interface AttemptService {
    List<Attempt> findByUser(Person person);
    void save(Attempt attempt);
}
