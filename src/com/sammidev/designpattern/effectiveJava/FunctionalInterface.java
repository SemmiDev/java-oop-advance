package com.sammidev.designpattern.effectiveJava;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    public void doSomething();
}

abstract class Template{

    public void doSomething() {
        System.out.println("Abdul Raud");
        System.out.println("Aditya Andika Putra");
        System.out.println("Aditya Fauzan");
        System.out.println("Ayatullah Ramadhan Jacoeb");
        System.out.println("Dandi Arnanda");
        System.out.println("Gusnur");
        System.out.println(getTheLastName());
    }

    protected abstract String getTheLastName();

    public static void main(String[] args) {
        new OneTemplateImplementation().doSomething();
    }
}

class OneTemplateImplementation extends Template {

    @Override
    protected String getTheLastName() {
        return "Sammi Aldhi Yanto";
    }
}