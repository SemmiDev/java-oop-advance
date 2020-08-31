package com.sammidev.designpattern.interfaceAbstract;

public class App {
    public static void main(String[] args) {

        DataStorage storage = new FileStorage();
        storage.save("halo sam");
        DataExporter explorer = new toWord();
        explorer.execuute();
    }
}

interface DataStorage{
    public void save(String data);
}

class FileStorage implements DataStorage{

    @Override
    public void save(String data) {
        System.out.println(data);
    }
}


class toWord extends DataExporter {

    @Override
    public void verifData() {
        System.out.println("verif to mysql");
    }

    @Override
    public void getData() {
        System.out.println("from mysql");
    }

    @Override
    public void exportData() {
        System.out.println("to whatever");
    }
}