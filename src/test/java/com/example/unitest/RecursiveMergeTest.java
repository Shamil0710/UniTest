package com.example.unitest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecursiveMergeTest {
    static class IntegerSumMerge extends RecursiveMerge<Integer> {
        @Override
        public Integer merge(Integer first, Integer second) {
            return first + second;
        }
    }

    @Test
    void merge_sumOfIntegers() {
        RecursiveMerge<Integer> merger = new IntegerSumMerge();
        assertEquals(10, merger.merge(List.of(1, 2, 3, 4)));
    }

    @Test
    void merge_singleElement() {
        RecursiveMerge<Integer> merger = new IntegerSumMerge();
        assertEquals(5, merger.merge(List.of(5)));
    }

    @Test
    void merge_emptyList_throwsException() {
        RecursiveMerge<Integer> merger = new IntegerSumMerge();
        assertThrows(IllegalArgumentException.class, () -> merger.merge(List.of()));
    }
}
