package com.example.spring_boot.controller;

import com.example.spring_boot.dto.AttemptDTO;
import com.example.spring_boot.model.Attempt;
import com.example.spring_boot.model.Person;
import com.example.spring_boot.security.PersonDetails;
import com.example.spring_boot.services.implementation.AttemptServiceImpl;
import com.example.spring_boot.services.implementation.UserServiceImpl;
import com.example.spring_boot.util.AreaCheck;
import com.example.spring_boot.util.Validator;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RequestMapping("/auth")
@RestController
public class StartController {
    private final AttemptServiceImpl attemptService;
    private final UserServiceImpl userService;

    @Autowired
    public StartController(AttemptServiceImpl attemptService, UserServiceImpl userService) {
        this.attemptService = attemptService;
        this.userService = userService;
    }

    @PostMapping("/list")
    public List<AttemptDTO> getAttempts() {
        return AttemptDTO.transfer(attemptService.findByUser(userService.findOneByUsername(getUsername())));
    }

    @PostMapping("/save/attempt")
    public List<AttemptDTO> saveAttempt(@RequestBody @Valid Attempt attempt) {
        attempt.setOwner(userService.findOneByUsername(getUsername()));
        if (Validator.validate(attempt)) {
            return doSave(attempt);
        } else {
            return Collections.emptyList();
        }
    }

    @PostMapping("/save/attempt/from_graph")
    public List<AttemptDTO> saveAttemptFromG(@RequestBody Attempt attempt) {
        attempt.setOwner(userService.findOneByUsername(getUsername()));
        return doSave(attempt);
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getUsername();
    }

    private List<AttemptDTO> doSave(Attempt attempt) {
        attempt.setDateOfHit(new Date());
        long start = System.nanoTime();
        attempt.setHit(AreaCheck.checkArea(attempt.getX(), attempt.getY(), attempt.getR()));
        long finish = System.nanoTime();
        attempt.setTimeWork(finish - start);
        attempt.getOwner().setId(userService.findOneByUsername(attempt.getOwner().getUsername()).getId());
        attemptService.save(attempt);
        return AttemptDTO.transfer(attemptService.findByUser(attempt.getOwner()));
    }
}
