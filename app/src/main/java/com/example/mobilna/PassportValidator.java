package com.example.mobilna;

public class PassportValidator {

    public String validate_number(int number) {
        if (number >= 0 && number <= 2) {
            return "";
        } else {
            return "Cyfra musi być z przedziału 0-2";
        }
    }

    public String validate_input(String input) {
        if (input == null) {
            return "Pole nie może być puste";
        }

        if (input.matches(".*\\d.*")) {
            return "Pole nie może zawierać cyfr";
        }

        if (input.isEmpty()) {
            return "Pole nie może być puste";
        }

        return "";
    }
}
