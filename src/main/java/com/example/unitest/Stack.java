package com.example.unitest;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Сделать ревью кода (реализация стека на основе массива, который хранит в себе Element)
 *
 * @param <T>
 */
//сделал стек дженериком вместо Element-класса, чтобы можно было хранить любые типы
public class Stack<T> {
    //сделал private для соблюдения инкапсуляции
    private int size = 0;
    //сделал private, чтобы нельзя было напрямую менять массив
    private T[] elements;

    //инициализация массива на 2 элемента
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (T[]) new Object[2];
    }

    //раньше массив увеличивался только на +1 это неэффективно, при если массив заполнении будет происходить копирование
    //теперь увеличиваем в 2 раза сложность push становится O(1)
    public void push(T o) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size * 2);
        elements[size++] = o;
    }

    public T pop() {
        // теперь EmptyStackException, менее общий Exception
        if (size == 0)
            throw new EmptyStackException();

        //уменьшаем size перед возвратом
        T elem = elements[--size];

        // обнуляем ссылку, чтобы помочь GC (иначе "висячие" ссылки будут висеть в массиве)
        elements[size] = null;

        return elem;
    }

    //добавил полезные методы, часто используемые при работе с коллекциями
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
