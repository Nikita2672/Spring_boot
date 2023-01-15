package com.example.spring_boot.repositories;

import com.example.spring_boot.model.Attempt;
import com.example.spring_boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    List<Attempt> findAllByOwner(Person person);
}
