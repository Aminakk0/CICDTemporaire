package edu.tp1.toolkit;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorLiteTest {

    private final CalculatorLite calc = new CalculatorLite();

    @Test
    void add_shouldSumTwoNumbers() {
        assertEquals(7, calc.add(3, 4));
        assertEquals(-1, calc.add(2, -3));
    }

    @Test
    void subtract_shouldSubtractTwoNumbers() {
        assertEquals(-1, calc.subtract(3, 4));
        assertEquals(5, calc.subtract(2, -3));
    }

    @Test
    void multiply_shouldMultiplyTwoNumbers() {
        assertEquals(12, calc.multiply(3, 4));
        assertEquals(-6, calc.multiply(2, -3));
        assertEquals(0, calc.multiply(123, 0));
    }

    @Test
    void divide_shouldDivideTwoNumbers_integerDivision() {
        assertEquals(2, calc.divide(9, 4)); // division entière
        assertEquals(-3, calc.divide(9, -3));
    }

    @Test
    void divide_byZero_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }
}