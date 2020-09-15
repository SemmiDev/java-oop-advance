package com.sammidev.datastructure;


import java.util.HashSet;
import java.util.Set;

public class Generic {
    public static void main(String[] args) {

        SampleMap<String, String, String> data = new SampleMap<>("Sammi", "sammidev@gmail.com", "sammidev@gmail.com");
        Set<SampleMap<String, String, String>> mapList = new HashSet<>();
        mapList.add(data);
        mapList.add(data);
        mapList.forEach(val -> {
            System.out.println(val.toString());
        });
    }

}

class SampleMap<A,B,String> {
    A username;
    B password;
    String email;

    public SampleMap(A username, B password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public A getUsername() {
        return username;
    }

    public B getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public java.lang.String toString() {
        return "SampleMap{" +
                "username=" + username +
                ", password=" + password +
                ", email=" + email +
                '}';
    }

}