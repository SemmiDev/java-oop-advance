package com.sammidev.designpattern.interfaceAbstract;

public abstract class DataExporter {

    public void verifData() {
        System.out.println("verifikasi");
    }

    public void getData() {
        System.out.println("get all data from database");
    }

    public abstract void exportData();

    public final void execuute() {
        verifData();
        getData();
        exportData();
    }
}