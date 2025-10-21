package edu.tp1.toolkit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeServiceTest {

    private final PalindromeService svc = new PalindromeService();

    @Test
    @DisplayName("Palindrome: null -> IllegalArgumentException")
    void palindrome_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> svc.isPalindrome(null));
    }

    @Test
    @DisplayName("Palindrome: vide et espaces -> true (définition standard)")
    void palindrome_empty_and_spaces_true() {
        assertTrue(svc.isPalindrome(""));
        assertTrue(svc.isPalindrome("   "));
    }

    @Test
    @DisplayName("Palindrome: ignore casse, espaces, ponctuation")
    void palindrome_ignores_case_spaces_punct() {
        assertTrue(svc.isPalindrome("Kayak"));
        assertTrue(svc.isPalindrome("A man, a plan, a canal: Panama!"));
        assertTrue(svc.isPalindrome("No 'x' in Nixon"));
    }

    @Test
    @DisplayName("Palindrome: accents ignorés")
    void palindrome_ignores_accents() {
        assertTrue(svc.isPalindrome("Élu par cette crapule"));
        assertFalse(svc.isPalindrome("École"));
    }

    @Test
    @DisplayName("Palindrome: cas négatifs simples")
    void palindrome_negative_cases() {
        assertFalse(svc.isPalindrome("Hello"));
        assertFalse(svc.isPalindrome("abca"));
    }
}
