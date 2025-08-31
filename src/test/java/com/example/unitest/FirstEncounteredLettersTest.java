package com.example.unitest;

import org.junit.jupiter.api.Test;

import static com.example.unitest.Encounter.getFirstEncounteredLetters;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FirstEncounteredLettersTest {
    @Test
    void testExample1() {
        // (abdvxv, 2) → ['a','v']
        assertArrayEquals(new char[]{'a', 'v'}, getFirstEncounteredLetters("abdvxv", 2));
    }

    @Test
    void testExample2() {
        // (atttbdvvxaxxa, 3) → ['b','v','a']
        assertArrayEquals(new char[]{'b', 'v', 'a'}, getFirstEncounteredLetters("atttbdvvxaxxa", 3));
    }

    @Test
    void testSingleChar() {
        // ("a", 1) → ['a']
        assertArrayEquals(new char[]{'a'}, getFirstEncounteredLetters("a", 1));
    }

    @Test
    void testInvalidInput_emptyString() {
        // Пустая строка → исключение
        assertThrows(IllegalArgumentException.class, () -> getFirstEncounteredLetters("", 2));
    }

    @Test
    void testInvalidInput_nullString() {
        // null → исключение
        assertThrows(IllegalArgumentException.class, () -> getFirstEncounteredLetters(null, 1));
    }

    @Test
    void testInvalidInput_notEnoughFrequencies() {
        // ("abc", 4) → невозможно найти символы с частотами 1,2,3,4 → исключение
        assertThrows(IllegalArgumentException.class, () -> getFirstEncounteredLetters("abc", 4));
    }
}
