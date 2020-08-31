package com.sammidev.designpattern.templateMethod;

public class App {
    public static void main(String[] args) {
        ReportGenerator report1 = new DatabaseToPdf();
        report1.generateReport();
        ReportGenerator report2 = new CsvToXlsx();
        report2.generateReport();

    }
}

class CsvToXlsx extends ReportGenerator {

    @Override
    public void ambilData() {
        System.out.println("baca daro csv");
    }

    @Override
    public void generateOutput() {
        System.out.println("generate report xls");
    }
}

class DatabaseToPdf extends ReportGenerator{

    @Override
    public void ambilData() {
        System.out.println("from db");
    }

    @Override
    public void generateOutput() {
        System.out.println("generate pdf");
    }
}


abstract class ReportGenerator {

    public abstract void ambilData();

    public void ambilTemplateReport() {
        System.out.println("Menggunakan template merah");

    }
    public void compileReport() {
        System.out.println("Menggabungkan data dengan template");
    }

    public abstract void generateOutput();

    public final void generateReport() {
        ambilData();
        ambilTemplateReport();
        compileReport();
        generateOutput();
    }
}
