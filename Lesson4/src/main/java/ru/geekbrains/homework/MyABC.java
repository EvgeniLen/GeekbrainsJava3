package ru.geekbrains.homework;

public class MyABC {
    static final Object mon = new Object();
    static volatile String str = "A";
    static final int num = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (!str.equals("A")) {
                            mon.wait();
                        }
                        System.out.print(str);
                        str = "B";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (!str.equals("B")) {
                            mon.wait();
                        }
                        System.out.print(str);
                        str = "C";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (!str.equals("C")) {
                            mon.wait();
                        }
                        System.out.print(str);
                        str = "A";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
