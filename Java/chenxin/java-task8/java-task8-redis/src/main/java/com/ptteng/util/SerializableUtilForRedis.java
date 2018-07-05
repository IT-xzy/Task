package com.ptteng.util;

import org.springframework.stereotype.Component;

import java.io.*;
@Component
public class SerializableUtilForRedis {
    //存入缓存时调用
    public byte[] enSerializable(Object value) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(value);
//        return byteArrayOutputStream;
        return byteArrayOutputStream.toByteArray();
    }
    //从缓存中取值时调用
    public Object deSerializable(String value) throws IOException, ClassNotFoundException {
        if (value ==null) return null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(value.getBytes());

        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }
}
