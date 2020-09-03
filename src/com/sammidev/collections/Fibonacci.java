package com.sammidev.collections;

import java.util.*;

class App {
    public static void main(String[] args) {

        /* LIST digunakan untuk menyimpan sekumpulan objek berdasarkan urutan masuk (ordered) dan menerima duplikat. */
        /* SET tidak boleh ada duplikasi nilai di dalamnya. Urutan maupun letak dari anggota tidaklah penting,
             hanya keberadaan anggota saja yang penting. */
        /* Map Adalah untuk menyimpan objek pada Map, perlu sepasang objek, yaitu key yang bersifat unik dan nilai yang disimpan. */


        List<Student> students = new ArrayList<>();
        students.add(new Student("0001","Sammidev"));
        students.add(new Student("0002","Aditya"));
        showList(students);

        System.out.println("===== addAll");
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(new Student("0003","Selvi"));
        students.addAll(students1);
        showList(students);

        // removeall
        System.out.println("===== remove");
        students.removeAll(students1);
        showList(students);

        // retainall
        System.out.println("===== retain");
        students.retainAll(students1);
        showList(students);

        Set<Integer> numbers = new LinkedHashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        showSet(Collections.singleton(numbers));

        Map<Integer,String> mapList = Map.of(
                1,"satu",
                2,"dua"
        );
        showMap(mapList);
        mapList.get(0);
        mapList.remove(0); // delete index
        mapList.clear(); // delete all
        mapList.replace(1,"change");
        mapList.clear(); // delete all
        mapList.isEmpty();
        int size = mapList.size();


        Map<Integer,Integer> hashTable = new HashMap<>();
        hashTable.put(1,1);
        hashTable.put(2,2);
        System.out.println(hashTable.entrySet());

    }

    public static void showList(List<Student> studentList){
        for (Student a : studentList) {
            System.out.println(a.getNisn()+ " -> " + a.getName());
        }
    }
    public static void showSet(Set<Object> objectSet){
        Iterator iterator = objectSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public static void showMap(Map<Integer,String> listMap) {
        System.out.println(listMap.entrySet());
    }
}

class Student {

    private final String nisn;
    private final String name;

    public Student(String nisn, String name) {
        this.nisn = nisn;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNisn() {
        return nisn;
    }
}


