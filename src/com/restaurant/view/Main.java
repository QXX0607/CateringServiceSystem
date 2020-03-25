package com.restaurant.view;

public class Main {
    static Thread threadObjectA;
    static Thread threadObjectB;

    public static void main(String[] args) {

        Runnable o1 = new MusicPlay();
        Runnable o2 = new mainPage();
        threadObjectA = new Thread(o1);
        threadObjectB = new Thread(o2);
        threadObjectA.start();
        threadObjectB.start();
    }
}
