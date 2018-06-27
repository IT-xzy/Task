package com.fangyuyang.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

public class Strategy {

    private Storage storage;

    public void getStorage(InputStream inputStream) {
         storage.operate(inputStream);
    }
    public void setStorage(Storage storage){
        this.storage = storage;
    }
}
