package ru.geekbrains.homework;


import ru.geekbrains.homework.fruit.Apple;
import ru.geekbrains.homework.fruit.Box;
import ru.geekbrains.homework.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MyMain {

    public static void main(String[] args) {
        //exercise 1
        Integer[] arr = {1, 2, 3, 4, 5};

        changeArr(arr, 2, 0);

        for (Integer s : arr) {
            System.out.println(s);
        }
        //exercise 2
        ArrayList<Integer > arrList = toArrayList(arr);

        for (Integer  s : arrList) {
            System.out.println(s);
        }

        //exercise 3

        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        ArrayList<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());

        Box<Apple> boxApl1 = new Box<>(apples);
        Box<Orange> boxOrg1 = new Box<>(oranges);

        System.out.println(boxApl1.getWeight());
        System.out.println(boxOrg1.getWeight());

        System.out.println(boxApl1.compare(boxOrg1));
        boxApl1.addFruits(new Apple());
        System.out.println(boxApl1.compare(boxOrg1));

        ArrayList<Apple> apples1 = new ArrayList<>();

        Box<Apple> boxApl2 = new Box<>(apples1);

        boxApl2.addFruits(new Apple());

        boxApl1.putInAnotherBox(boxApl2);

        System.out.println("Пересыпали, вес первой коробки - " + boxApl1.getWeight());
        System.out.println("Пересыпали, вес второй коробки - " + boxApl2.getWeight());

    }

    public static <T> void changeArr(T[] arr, int a, int b){
        T firstElem = arr[a];
        arr[a] = arr[b];
        arr[b] = firstElem;
    }

    public static <T> ArrayList<T> toArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }

}
