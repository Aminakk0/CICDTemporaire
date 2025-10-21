package edu.tp1.toolkit;

import java.util.Arrays;

public class WordCounter {

    public int count(String input) {
        if (input == null) throw new IllegalArgumentException("input must not be null");

        String s = input.trim();
        if (s.isBlank()) return 0;

        s = s.replaceAll("[_\\-]+", " ");
        s = s.replaceAll("[\\p{Punct}]", " ");
        s = s.replaceAll("\\s+", " ").trim();

        if (s.isEmpty()) return 0;

        return (int) Arrays.stream(s.split(" "))
                .filter(tok -> !tok.isBlank())
                .count();
    }
}
