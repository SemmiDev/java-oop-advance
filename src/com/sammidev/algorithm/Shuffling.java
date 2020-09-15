package com.sammidev.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shuffling {
    public static void main(String[] args) {
        String n[] = {
                new String("sam"),
                new String("adit"),
                new String("dandi"),
                new String("ayatullah")
        };

        List a = Arrays.asList(n);

        System.out.println("REVERSE");
        Collections.reverse(a);

        System.out.println("FILL");
        System.out.println("COPY");
        System.out.println("SWAP");
        System.out.println("ADD_ALL");
    }
}
