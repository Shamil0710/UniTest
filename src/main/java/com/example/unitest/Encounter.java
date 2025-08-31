package com.example.unitest;

import java.util.Arrays;

/**
 * Напишите функцию, char[] getFirstEncounteredLetters(String str, int n),
 * которая возвращает массив длиной n, в котором в ячейке под индексом k-1
 * будет находиться первый символ, встречающийся в строке str ровно k раз. На вход подаются
 * только английские буквы в нижнем регистре (a - z).
 */
public class Solution {
    static char[] getFirstEncounteredLetters(String str, int n) {
        char[] result = new char[n];
        // заполняем пустыми символами
        Arrays.fill(result, '\0');

        //Считаем частоты
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        //Проходим строку слева направо
        for (char c : str.toCharArray()) {
            int count = freq[c - 'a'];
            if (count >= 1 && count <= n) {
                int index = count - 1;
                if (result[index] == '\0') {
                    result[index] = c;
                }
            }
        }

        return result;
    }
}
