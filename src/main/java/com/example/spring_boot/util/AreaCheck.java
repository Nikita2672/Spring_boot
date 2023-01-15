package com.example.spring_boot.util;

public class AreaCheck {
    public static boolean checkArea(float x, float y, float r) {
        if (x >= 0 && y >= 0) {
            return (y <= (-x + r));
        } else if (x < 0 && y >= 0) {
            return ((x * x + y * y) <= (r * r));
        } else if (x <= 0 && y < 0) {
            return ((x > -r) && (y > (-r / 2)));
        } else {
            return false;
        }
    }
}
