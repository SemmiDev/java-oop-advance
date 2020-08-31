package com.sammidev.designpattern.factory;

public class App {
    public static void main(String[] args) {
        String name = "Sammidev";
        JurusanIT jurusanIT = JurusanITFactory.createJurusan("SI");
        jurusanIT.save(name);
    }
}

interface JurusanIT {

    public void save(String name);
}


class JurusanITFactory {

    public static JurusanIT createJurusan(JurusanType type) {
        if (null != type) switch (type){
            case SI:
                return new SistemInformasi("UNRI");
            case SK:
                return new SistemKomputer("UNRI");
            case TK:
                return new TeknikKomputer("UNRI");
            case TI:
                return new TeknikInformatika("UNRI");
            default:
                break;
        }
        throw new UnsupportedOperationException("jurusan type belum di support yak");
    }

    public static JurusanIT createJurusan(String type) {
        if (null != type) switch (type.toLowerCase().trim()){
            case "si":
                return new SistemInformasi("UNRI");
            case "sk":
                return new SistemKomputer("UNRI");
            case "tk":
                return new TeknikKomputer("UNRI");
            case "ti":
                return new TeknikInformatika("UNRI");
            default:
                break;
        }
        throw new UnsupportedOperationException("jurusan type belum di support yak");
    }

    public enum JurusanType {
        SI, SK, TI, TK
    }
}

class SistemInformasi implements JurusanIT {

    private String universitas;
    private final String jurusan = "Sistem Informasi";

    public SistemInformasi(String universitas) {
        this.universitas = universitas;
    }

    @Override
    public void save(String name) {
        System.out.println("menyimpan nama : " + name);
        System.out.println("menyimpan universitas : " + universitas);
        System.out.println("jurusan : " + jurusan);
    }
}

class SistemKomputer implements JurusanIT{
    private String universitas;
    private final String jurusan = "Sistem Informasi";

    public SistemKomputer(String universitas) {
        this.universitas = universitas;
    }

    @Override
    public void save(String name) {
        System.out.println("menyimpan nama : " + name);
        System.out.println("menyimpan universitas : " + universitas);
        System.out.println("jurusan : " + jurusan);
    }
}


class TeknikInformatika implements JurusanIT{
    private String universitas;
    private final String jurusan = "Sistem Informasi";

    public TeknikInformatika(String universitas) {
        this.universitas = universitas;
    }

    @Override
    public void save(String name) {
        System.out.println("menyimpan nama : " + name);
        System.out.println("menyimpan universitas : " + universitas);
        System.out.println("jurusan : " + jurusan);
    }
}

class TeknikKomputer implements JurusanIT{

    private String universitas;
    private final String jurusan = "Sistem Informasi";

    public TeknikKomputer(String universitas) {
        this.universitas = universitas;
    }

    @Override
    public void save(String name) {
        System.out.println("menyimpan nama : " + name);
        System.out.println("menyimpan universitas : " + universitas);
        System.out.println("jurusan : "+ jurusan);
    }
}