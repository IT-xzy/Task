package com.student.util;


import java.io.IOException;
import java.io.InputStream;

public class ContextSpringFactory {

    private Storage storage;


    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void uploadFile(InputStream inputStream, String key) throws IOException {
        storage.uploadFile(inputStream,key);
    }

    public  InputStream download(String key) throws IOException {
        return storage.download(key);
    }

//    public void doAction(Storage storage, String key, InputStream inputStream) throws IOException {
//
//        storage.download(key);
//        storage.uploadFile(inputStream,key);
//
//
//    }
}
