package ru.geekbrains.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MyTest {
    ActionOnArray action;

    @BeforeEach
    public void init(){
        action = new ActionOnArray();
    }

    public static Stream<Arguments> dataForGetArr() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1, 2, 3, 5}, new int[]{1, 13, 14, 13, 4, 1, 2, 3, 5}));
        list.add(Arguments.arguments(new int[]{5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        list.add(Arguments.arguments(new int[]{}, new int[]{1, 3, 4}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForGetArr")
    public void testGetArr(int[] resultArr, int[] arr) {
        Assertions.assertArrayEquals(resultArr, action.getArr(arr));
    }

    @Test
    public void testGetArr1(){
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7}, action.getArr(new int[]{4, 1, 2, 3, 5, 6, 7}));
    }

    @Test
    public void testGetArr2(){
        Assertions.assertThrows(RuntimeException.class, ()-> action.getArr(new int[]{1,2,3}));
    }

    public static Stream<Arguments> dataForCheckArr() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(true, new int[]{1, 1, 4, 4, 4, 1, 4}));
        list.add(Arguments.arguments(false, new int[]{1, 4, 3, 1, 4, 4}));
        list.add(Arguments.arguments(false, new int[]{1, 1, 1}));
        list.add(Arguments.arguments(false, new int[]{4, 4, 4}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArr")
    public void testCheckArr(boolean result, int[] arr) {
        Assertions.assertEquals(result, action.checkArray(arr));
    }
}