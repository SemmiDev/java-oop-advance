package com.sammidev.designpattern.builder;

import java.time.LocalDate;
/*import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;*/

public class App {
    public static void main(String[] args) {

        Student sam = Student.builder()
                .name("Sammidev")
                .address("tinggam")
                .nisn("121294")
                .age(19)
                .gender(Student.gender.MALE)
                .kelas("XII MIPA 1")
                .jurusan("MIPA")
                .build();
    }
}


class Student {

    private String nisn;
    private String name;
    private int age;
    private String address;
    private gender gender;
    private String kelas;
    private String jurusan;

    public static Student.Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private Student student;

        Builder() {
            student = new Student();
        }

        public Student.Builder nisn(String nisn) {
            student.setNisn(nisn);
            return this;
        }
        public Student.Builder name(String name) {
            student.setNisn(name);
            return this;
        }
        public Student.Builder age(int age) {
            student.setAge(age);
            return this;
        }
        public Student.Builder address(String address) {
            student.setAddress(address);
            return this;
        }
        public Student.Builder gender(gender gender) {
            student.setGender(gender);
            return this;
        }
        public Student.Builder kelas(String kelas) {
            student.setKelas(kelas);
            return this;
        }
        public Student.Builder jurusan(String jurusan) {
            student.setNisn(jurusan);
            return this;
        }

        public Student build() {
            if(student.getNisn() == null){
                throw new NullPointerException("NISN HARUS DIISI");
            }

            if(student.getAge() != 0 && student.getAge() > 17) {
                throw new IllegalStateException("min 17");
            }

            return student;
        }
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student.gender getGender() {
        return gender;
    }

    public void setGender(Student.gender gender) {
        this.gender = gender;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    static enum gender {
        MALE, FEMALE
    }

}

/*@Data @Builder
class Customer {

    @NonNull
    private String nama;

    @NonNull
    private String email;
    private String noHp;
    private LocalDate tanggalLahir;
    private JenisKelamin jenisKelamin;
    private String alamat;
    private String kodepos;
    private String kelurahan;
    private String kecamatan;
    private String kabupatenKota;
    private String provinsi;

    public Customer(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public Customer(String nama, String email, String noHp) {
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
    }

    public static enum JenisKelamin { PRIA, WANITA }
}*/

