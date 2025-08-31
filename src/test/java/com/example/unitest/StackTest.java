package com.example.unitest;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    void pushAndPop_singleElement() {
        Stack<Integer> stack = new Stack<>();
        stack.push(42);
        assertEquals(42, stack.pop());
    }

    @Test
    void pushAndPop_multipleElements() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
    }

    @Test
    void pop_emptyStack_throwsException() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void isEmptyAndSize() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }
}
