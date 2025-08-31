package com.example.unitest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Напишите функцию, char[] getFirstEncounteredLetters(String str, int n),
 * которая возвращает массив длиной n, в котором в ячейке под индексом k-1
 * будет находиться первый символ, встречающийся в строке str ровно k раз. На вход подаются
 * только английские буквы в нижнем регистре (a - z).
 */
public class Encounter {
    static char[] getFirstEncounteredLetters(String str, int n) {
        if (str == null || str.isEmpty() || n <= 0) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }

        //Подсчёт количества вхождений символов
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        //Результат
        char[] result = new char[n];
        //чтобы отметить, что частота уже найдена
        boolean[] filled = new boolean[n];
        int filledCount = 0;

        //Проходим строку по порядку — ищем первый символ каждой частоты
        for (char c : str.toCharArray()) {
            int freq = counts.get(c);
            if (freq >= 1 && freq <= n && !filled[freq - 1]) {
                result[freq - 1] = c;
                filled[freq - 1] = true;
                filledCount++;
            }
            if (filledCount == n) {
                break;
            }
        }

        if (filledCount < n) {
            throw new IllegalArgumentException("Недостаточно символов для всех частот до " + n);
        }

        return result;
    }
}
