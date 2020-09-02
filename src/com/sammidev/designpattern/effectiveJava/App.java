package com.sammidev.designpattern.effectiveJava;


import java.util.*;

public class App{
    public static void main(String[] args) {
        PhoneNumber a = PhoneNumber.of("USA","0823xxx", 1);
        System.out.println(a);
        System.out.printf("%s", PhoneNumber.of("IND","0823xxx", 2));
    }
}

class PhoneNumber implements Formattable, Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> NUMBER_COMPARATOR = Comparator.comparingInt((PhoneNumber p) -> p.hash);
    private final String numCodeCountry;
    private final String phoneNumber;
    private final int hash;
    private static final List<String> listPhoneSupport = List.of("USA","IND","AUS","MLY");
    public PhoneNumber(String numCodeCountry, String phoneNumber, int hash) {
        this.numCodeCountry = numCodeCountry;
        this.phoneNumber = phoneNumber;
        this.hash = Objects.hash(this.numCodeCountry, this.phoneNumber);
    }

    public static PhoneNumber of(String numCodeCountry, String phoneNumber, int hash){
        boolean length =  checkArgument(phoneNumber.length() != 12);
        if (length) {
            for (var s : listPhoneSupport) {
                if (!numCodeCountry.contains(s)) {
                    continue;
                }
                return new PhoneNumber(numCodeCountry, phoneNumber, hash);
            }
        }
        return null;
    }

    private static boolean checkArgument(boolean b) {
        if (!b) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof PhoneNumber) {
            PhoneNumber other =  (PhoneNumber) obj;
            return this.phoneNumber.equals(other.phoneNumber) &&
                    Objects.equals(this.numCodeCountry, other.numCodeCountry);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hash;
    }


    @Override
    public String toString() {
        return "PhoneNumber{" +
                "numCodeCountry='" + numCodeCountry + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hash=" + hash +
                '}';
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%s - %s - %d", numCodeCountry, phoneNumber, hash);
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return NUMBER_COMPARATOR
                .compare(this, o);
    }
}
