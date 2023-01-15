package com.example.spring_boot.services.implementation;

import com.example.spring_boot.model.Attempt;
import com.example.spring_boot.model.Person;
import com.example.spring_boot.repositories.AttemptRepository;
import com.example.spring_boot.services.interfaces.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AttemptServiceImpl implements AttemptService {
    private final AttemptRepository attemptRepository;

    @Autowired
    public AttemptServiceImpl(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    @Override
    public List<Attempt> findByUser(Person person) {
        return attemptRepository.findAllByOwner(person);
    }

    @Override
    @Transactional
    public void save(Attempt attempt) {
        attemptRepository.save(attempt);
    }

    public List<Attempt> getAttempts() {
        return attemptRepository.findAll();
    }
}
