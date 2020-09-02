package com.sammidev.designpattern.effectiveJava;
import java.util.function.Supplier;

public class StrategyImplementation {
    private final Supplier<String> supplier;

    private StrategyImplementation(Supplier<String> supplier) {
        this.supplier = supplier;
    }
    public static StrategyImplementation of(Supplier<String> supplier) {
        return new StrategyImplementation(supplier);
    }

    public void doSomething() {
        System.out.println("Abdul Raud");
        System.out.println("Aditya Andika Putra");
        System.out.println("Aditya Fauzan");
        System.out.println("Ayatullah Ramadhan Jacoeb");
        System.out.println("Dandi Arnanda");
        System.out.println("Gusnur");
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
        StrategyImplementation.of(() ->  "Sammi Aldhi Yanto").doSomething();
    }
}