package com.sammidev.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {

        String n[] = {
                new String("sam"),
                new String("adit"),
                new String("dandi"),
                new String("ayatullah")
        };

        List a = Arrays.asList(n);
        Collections.sort(a);
        a.forEach(show -> {
            System.out.println(show);
        });
    }
}