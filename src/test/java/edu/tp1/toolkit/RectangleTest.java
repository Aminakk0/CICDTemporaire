package edu.tp1.toolkit;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void constructor_shouldRejectNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(2, -1));
    }

    @Test
    void area_and_perimeter_shouldBeCorrect() {
        Rectangle r = new Rectangle(3, 4);
        assertEquals(12.0, r.area(), 1e-9);
        assertEquals(14.0, r.perimeter(), 1e-9);
    }

    @Test
    void scale_shouldReturnNewRectangle() {
        Rectangle r = new Rectangle(3, 4);
        Rectangle r2 = r.scale(2.0);

        assertEquals(6.0, r2.getWidth(), 1e-9);
        assertEquals(8.0, r2.getHeight(), 1e-9);

        // immuabilité : l’original ne change pas
        assertEquals(3.0, r.getWidth(), 1e-9);
        assertEquals(4.0, r.getHeight(), 1e-9);
    }

    @Test
    void scale_negative_shouldThrow() {
        Rectangle r = new Rectangle(1, 1);
        assertThrows(IllegalArgumentException.class, () -> r.scale(-0.1));
    }
}
