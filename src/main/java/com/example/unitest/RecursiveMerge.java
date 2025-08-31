package com.example.unitest;

import java.util.List;

/**
 * Есть метод, который мерджит 2 каких-то объекта, как он это делает неважно (например, для
 * чисел это может быть сумматор).
 * Нужно написать рекурсивный метод, который мерджит лист таких элементов используя метод
 * merge(T first, T second).
 */
public abstract class RecursiveMerge<T> {
    /**
     * Merges two instances of {@link T}.
     * Example: for Integer it can be addition.
     */
    public abstract T merge(T first, T second);

    /**
     * Recursively merges list of values using {@link RecursiveMerge#merge(T, T)}.
     *
     * @param values list of T values
     * @return merged instance
     */
    public T merge(List<T> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть null или пустым");
        }

        if (values.size() == 1) {
            // базовый случай
            return values.get(0);
        }

        // рекурсия, первый элемент + результат слияния хвоста
        return merge(values.get(0), merge(values.subList(1, values.size())));
    }
}
