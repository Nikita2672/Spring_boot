package com.example.spring_boot.dto;

import com.example.spring_boot.model.Attempt;

import java.util.ArrayList;
import java.util.List;

public class AttemptDTO {
    private float x;
    private float y;
    private float r;
    private float timeWork;
    private String dateOfInit;
    private boolean hit;

    public AttemptDTO(Attempt attempt) {
        this.x = attempt.getX();
        this.y = attempt.getY();
        this.r = attempt.getR();
        this.timeWork = attempt.getTimeWork();
        this.dateOfInit = attempt.getDateOfHit().toString();
        this.hit = attempt.isHit();
    }

    public AttemptDTO(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static List<AttemptDTO> transfer(List<Attempt> attempts) {
        List<AttemptDTO> result = new ArrayList<>();
        for (Attempt attempt: attempts) {
            result.add(new AttemptDTO(attempt));
        }
        return result;
    }

    public float getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(float timeWork) {
        this.timeWork = timeWork;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public String getDateOfInit() {
        return dateOfInit;
    }

    public void setDateOfInit(String dateOfInit) {
        this.dateOfInit = dateOfInit;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
