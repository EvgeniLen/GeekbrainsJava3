package ru.geekbrains.homework.fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruits(T f){
        fruits.add(f);
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public Boolean compare(Box o) {
        return Math.abs(this.getWeight() - o.getWeight()) < 0.0001;
    }

    public void putInAnotherBox(Box<T> o){
        if (this.equals(o)){
            System.out.println("Так нельзя, укажите другую коробку");
        } else {
            o.fruits.addAll(fruits);
            fruits.clear();
        }
    }

}


