package ru.geekbrains.homework;


public class ActionOnArray {


    public int[] getArr(int[] arr) {
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == 4) {
                int[] newArr = new int[arr.length - (i + 1)];
                System.arraycopy(arr, i + 1, newArr, 0, newArr.length);
                return newArr;
            }
        }
        throw new RuntimeException();
    }

    public boolean checkArray(int[] arr) {
        boolean isContainsOne = false;
        boolean isContainsFour = false;
        for (int i : arr) {
            if (i != 4 && i != 1) return false;
            if (i == 4) isContainsFour = true;
            if (i == 1) isContainsOne = true;
        }
        return isContainsFour && isContainsOne;
    }
}
