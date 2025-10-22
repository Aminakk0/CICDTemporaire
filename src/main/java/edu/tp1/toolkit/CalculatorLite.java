package edu.tp1.toolkit;

/**
 * Petit utilitaire arithmétique pour les démonstrations de tests.
 */
public class CalculatorLite {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    /** Division entière. Lance IllegalArgumentException si b==0. */
    public int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Division par zéro");
        return a / b;
    }
}