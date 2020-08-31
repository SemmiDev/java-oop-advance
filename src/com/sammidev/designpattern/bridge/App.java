package com.sammidev.designpattern.bridge;

public class App {
    public static void main(String[] args) {
        Doc doc1 = new Doc();
        doc1.setContent("doc D1");
        doc1.setStorage(new GCPStorage());
        doc1.save();

        SecureDoc d2 = new SecureDoc();
        d2.setStorage(new AWSStorage());
        d2.setContent("data-rahasia");
        d2.save();
        d2.encrypt();
        String hasilDekripsi = d2.decrypt();
        System.out.println("Dokumen yang sudah didecrypt : "+hasilDekripsi);
    }
}

interface Storage {
    public void upload(String data);
    public String download();
    public void delete();
}


class GCPStorage implements Storage {
    private String data;

    @Override
    public void upload(String data) {
        System.out.println("Mengupload "+data+" ke Amazon cloud");
        this.data = data;
    }

    @Override
    public String download() {
        System.out.println("Mendownload "+data+" dari Amazon cloud");
        return data;
    }

    @Override
    public void delete() {
        data = null;
    }
}


class AWSStorage implements Storage {

    private String data;

    @Override
    public void upload(String data) {
        System.out.println("Mengupload "+data+" ke google cloud");
        this.data = data;
    }

    @Override
    public String download() {
        System.out.println("Mendownload "+data+" dari google cloud");
        return data;
    }

    @Override
    public void delete() {
        data = null;
    }
}

class Doc {

    private String content;
    private Storage storage;

    public void save() {
        storage.upload(content);
    }

    public void delete() {
        storage.delete();
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

}

class SecureDoc extends Doc {
    private String key;

    public void encrypt(){
        String data = getStorage().download();
        System.out.println("Mengenkripsi "+data);
        getStorage().upload("123" + data + "123");
    }

    public String decrypt(){
        String encrypted = getStorage().download();
        System.out.println("Dekripsi data "+encrypted);
        return encrypted.substring(3, encrypted.length() - 3);
    }
}
