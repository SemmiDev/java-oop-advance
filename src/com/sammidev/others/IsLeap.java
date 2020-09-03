package com.sammidev.others;

import java.util.Calendar;

import static java.util.Calendar.*;

public class IsLeap {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2020));
        System.out.println(doesLeapYear(2020));
        System.out.println(isLeapYear(2021));
        System.out.println(doesLeapYear(2021));
        System.out.println(isLeapYear(2022));
        System.out.println(doesLeapYear (2022));
    }

    public static boolean isLeapYear(int year) {
        Calendar calendar = getInstance();
        calendar.set(YEAR, year);
        int noOfDays = calendar.getActualMaximum(DAY_OF_YEAR);
        if (noOfDays > 365) {
            return true;
        }
        return false;
    }

    public static boolean doesLeapYear(int year) {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }
}