package edu.tp1.toolkit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    private final WordCounter wc = new WordCounter();

    @Test
    @DisplayName("WordCount: null -> IllegalArgumentException")
    void wordCount_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> wc.count(null));
    }

    @Test
    @DisplayName("WordCount: vide et espaces -> 0")
    void wordCount_empty_and_spaces_zero() {
        assertEquals(0, wc.count(""));
        assertEquals(0, wc.count("     "));
    }

    @Test
    @DisplayName("WordCount: espaces multiples & tabulations")
    void wordCount_multiple_spaces_and_tabs() {
        assertEquals(3, wc.count("one   two	three"));
    }

    @Test
    @DisplayName("WordCount: ponctuation simple")
    void wordCount_punctuation() {
        assertEquals(4, wc.count("Hello, world! Java: rocks."));
    }

    @Test
    @DisplayName("WordCount: accents conservés comme lettres")
    void wordCount_accents_are_letters() {
        assertEquals(3, wc.count("un été chaud"));
    }

    @Test
    @DisplayName("WordCount: tirets & underscores traités comme séparateurs")
    void wordCount_hyphens_and_underscores() {
        assertEquals(3, wc.count("foo-bar_baz"));
    }
}
