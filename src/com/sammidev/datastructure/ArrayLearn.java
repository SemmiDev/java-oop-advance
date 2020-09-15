//package com.sammidev.datastructure;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class ArrayLearn {
//    public static void main(String[] args) {
//
//        int data[] = new int[5];
//        Random random = new Random();
//        random.setSeed(System.currentTimeMillis());
//        for (int i = 0; i < data.length; i++)
//            data[i] = random.nextInt(100);
//        int[] origin = Arrays.copyOf(data, data.length);
//        System.out.println("before sort : " + Arrays.equals(data,origin));
//        Arrays.sort(data);
//        System.out.println("after sort : " + Arrays.equals(data,origin));
//        System.out.println(Arrays.toString(origin));
//        System.out.println(Arrays.toString(data));
//    }
//}
