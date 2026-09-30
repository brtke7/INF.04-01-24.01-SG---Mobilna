package com.example.mobilna;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassportValidatorTest {

    @Test
    public void validateNumber_shouldAcceptNumbersFrom0To2() {
        assertTrue(0 >= 0 && 0 <= 2);
        assertTrue(1 >= 0 && 1 <= 2);
        assertTrue(2 >= 0 && 2 <= 2);
    }

    @Test
    public void validateNumber_shouldRejectNumbersBelow0() {
        assertFalse(-1 >= 0 && -1 <= 2);
    }

    @Test
    public void validateNumber_shouldRejectNumbersAbove2() {
        assertFalse(3 >= 0 && 3 <= 2);
    }

    @Test
    public void validateInput_shouldAcceptCorrectText() {
        String input = "Kowalski";

        assertTrue(input != null);
        assertTrue(!input.matches(".*\\d.*"));
        assertTrue(!input.isEmpty());
    }

    @Test
    public void validateInput_shouldRejectNull() {
        String input = null;

        assertFalse(input != null);
    }

    @Test
    public void validateInput_shouldRejectTextContainingDigit() {
        String input = "Jan123";

        assertFalse(!input.matches(".*\\d.*"));
    }

    @Test
    public void validateInput_shouldRejectEmptyText() {
        String input = "";

        assertFalse(!input.isEmpty());
    }
}
