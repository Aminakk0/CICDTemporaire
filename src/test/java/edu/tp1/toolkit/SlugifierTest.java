package edu.tp1.toolkit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlugifierTest {

    private final Slugifier slugifier = new Slugifier();

    @Test
    @DisplayName("Slugifier: null -> IllegalArgumentException")
    void slugify_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> slugifier.slugify(null));
    }

    @Test
    @DisplayName("Slugifier: vide & espaces -> chaîne vide")
    void slugify_empty_and_spaces_to_empty() {
        assertEquals("", slugifier.slugify(""));
        assertEquals("", slugifier.slugify("    "));
    }

    @Test
    @DisplayName("Slugifier: accents, casse, ponctuation")
    void slugify_accents_case_punct() {
        assertEquals("cafe-au-lait", slugifier.slugify("Café au lait!"));
        assertEquals("l-ete-a-paris", slugifier.slugify("L'Été à Paris??"));
    }

    @Test
    @DisplayName("Slugifier: multiples séparateurs -> un seul '-' et trim des '-' en bord")
    void slugify_collapses_and_trims_hyphens() {
        assertEquals("hello-world", slugifier.slugify("  Hello   --   World  "));
        assertEquals("a-b-c", slugifier.slugify("__A__B__C__"));
    }

    @Test
    @DisplayName("Slugifier: caractères non alphanumériques (emoji, symboles) supprimés")
    void slugify_drops_symbols() {
        assertEquals("i-love-java", slugifier.slugify("I love Java"));
        assertEquals("price-100", slugifier.slugify("Price: 100€"));
    }

    @Test
    @DisplayName("Slugifier: déjà un slug -> idempotent")
    void slugify_idempotent() {
        assertEquals("already-slug", slugifier.slugify("already-slug"));
    }
}
