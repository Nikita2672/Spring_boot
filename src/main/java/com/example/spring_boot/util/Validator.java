package com.example.spring_boot.util;

import com.example.spring_boot.model.Attempt;

public class Validator {
    public static boolean validate(Attempt attempt) {
        return !(attempt.getX() < -3) && !(attempt.getX() > 5) && !(attempt.getY() > 5) && !(attempt.getY() < -3);
    }
}
