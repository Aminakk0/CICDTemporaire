package edu.tp1.toolkit;

import java.text.Normalizer;
import java.util.Locale;

public class PalindromeService {

    public boolean isPalindrome(String input) {
        if (input == null) throw new IllegalArgumentException("input must not be null");

        String cleaned = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^\\p{Alnum}]", "");

        if (cleaned.isBlank()) return true;

        int i = 0, j = cleaned.length() - 1;
        while (i < j) {
            if (cleaned.charAt(i++) != cleaned.charAt(j--)) return false;
        }
        return true;
    }
}
