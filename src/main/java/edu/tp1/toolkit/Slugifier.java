package edu.tp1.toolkit;

import java.text.Normalizer;
import java.util.Locale;

public class Slugifier {

    public String slugify(String input) {
        if (input == null) throw new IllegalArgumentException("input must not be null");

        String s = input.trim();
        if (s.isBlank()) return "";

        String noAccents = Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        String hyphenized = noAccents.toLowerCase(Locale.ROOT)
                .replaceAll("[^\\p{Alnum}]+", "-");

        String collapsed = hyphenized.replaceAll("-{2,}", "-")
                .replaceAll("^-+|-+$", "");

        return collapsed;
    }
}
