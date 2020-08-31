package com.sammidev.designpattern.metaprogramming;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {

        String className = "com.sammidev.designpattern.interfaceAbstract.DataExporter";
        Class classs = Class.forName(className);

        Method[] listOfMethod = classs.getMethods();

        for (Method m : listOfMethod) {
            System.out.println("method name : " + m.getName());
            System.out.println("=== argumen ===");

            for (Parameter p : m.getParameters()) {
                System.out.println("name parameter : " + p.getName());
                System.out.println("data type : " + p.getType().getName());
            }

            System.out.println("==== Argumen =====");
            System.out.println("return val data type : " + m.getReturnType().getName());
        }
    }
}