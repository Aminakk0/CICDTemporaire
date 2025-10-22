package edu.tp1.toolkit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    private final StringHelper helper = new StringHelper();

    @Test
    void isBlank_shouldDetectNullEmptyAndSpaces() {
        assertTrue(helper.isBlank(null));
        assertTrue(helper.isBlank(""));
        assertTrue(helper.isBlank("   "));
        assertFalse(helper.isBlank("  a  "));
    }

    @Test
    void reverse_shouldReverseOrReturnNull() {
        assertNull(helper.reverse(null));
        assertEquals("cba", helper.reverse("abc"));
        assertEquals("aba", helper.reverse("aba"));
    }

    @Test
    void isPalindrome_shouldIgnoreCaseAndSpaces() {
        assertTrue(helper.isPalindrome("Kayak"));
        assertTrue(helper.isPalindrome("n u r s e s   r u n"));
        assertFalse(helper.isPalindrome(null));
        assertFalse(helper.isPalindrome("Test"));
    }

    @Test
    void repeat_shouldRepeatStringNtimes() {
        assertEquals("", helper.repeat("X", 0));
        assertEquals("aaa", helper.repeat("a", 3));
        assertEquals("nullnull", helper.repeat(null, 2)); // String.valueOf(null) -> "null"
    }

    @Test
    void repeat_negative_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> helper.repeat("x", -1));
    }

    @Test
    void capitalize_shouldHandleCases() {
        assertNull(helper.capitalize(null));
        assertEquals("", helper.capitalize(""));
        assertEquals("Hello", helper.capitalize("hELLO"));
        assertEquals("A", helper.capitalize("a"));
    }

    @Test
    void splitWords_shouldSplitOnSpaces() {
        assertArrayEquals(new String[0], helper.splitWords(null));
        assertArrayEquals(new String[0], helper.splitWords("   "));
        assertArrayEquals(new String[]{"a","bb","ccc"}, helper.splitWords(" a   bb  ccc "));
    }
}
