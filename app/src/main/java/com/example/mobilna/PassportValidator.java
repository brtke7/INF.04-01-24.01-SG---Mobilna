package com.example.mobilna;

public class PassportValidator {

    public void validate_number(int number) {
        assert(number >= 0 && number <= 2);
    }

    public void validate_input(String input) {
        assert input != null;
        assert !input.matches(".*\\d.*");
        assert !input.isEmpty();
    }
}
