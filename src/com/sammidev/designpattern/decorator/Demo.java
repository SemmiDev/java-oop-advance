package com.sammidev.designpattern.decorator;

public class Demo {

    public static void main(String[] args) {
        File file = new File();
        SecureFile secureFile = new SecureFile(file);
        file.setContent("real content");
        file.save();
        secureFile.encrypt();
        secureFile.decrypt();
    }
}

class File {

    private String content;

    public File(String content) {
        this.content = content;
    }

    public File() {
    }

    public void save() {
        System.out.println(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


class SecureFile {

    private File file;

    public SecureFile() {
    }

    public SecureFile(File file) {
        this.file = file;
    }

    public void encrypt(){
        String plain = file.getContent();
        String encrypted = "123["+plain+"]123";
        file.setContent(encrypted);
        file.save();
    }

    public void decrypt(){
        String encrypted = file.getContent();
        String plain = encrypted.substring(4, encrypted.length() - 4);
        file.setContent(plain);
        file.save();
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
