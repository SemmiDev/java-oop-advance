package com.sammidev.others;

public class DeadLock {

    public static void main(String[] args) {

    }

    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

    public void method2() {
        synchronized (String.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (Integer.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

}
