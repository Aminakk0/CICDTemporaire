package edu.tp1.toolkit;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {

    /** true si s est null, vide ou ne contient que des espaces. */
    public boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /** Renvoie la chaîne inversée (null -> null). */
    public String reverse(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    /** Palindrome insensible à la casse et aux espaces. null -> false. */
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        String normalized = s.replaceAll("\\s+", "").toLowerCase();
        return normalized.equals(new StringBuilder(normalized).reverse().toString());
    }

    /** Répète s n fois (n>=0). n<0 -> IllegalArgumentException. null est traité comme "null". */
    public String repeat(String s, int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        String value = String.valueOf(s);
        StringBuilder sb = new StringBuilder(value.length() * n);
        for (int i = 0; i < n; i++) sb.append(value);
        return sb.toString();
    }

    /** Met la première lettre en majuscule, le reste en minuscule. Null -> null. */
    public String capitalize(String s) {
        if (s == null) return null;
        if (s.isEmpty()) return "";
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /** Découpe sur les espaces (trim + multi-espaces). Null -> tableau vide. */
    public String[] splitWords(String s) {
        if (s == null) return new String[0];
        String trimmed = s.trim();
        if (trimmed.isEmpty()) return new String[0];
        return trimmed.split("\\s+");
    }
}