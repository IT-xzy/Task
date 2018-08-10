package com.task6.util;

import com.task6.pojo.Person;

import java.io.*;

/**
 * Create by SongWu on 2018/8/1
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        serializePerson();
       Person person = deserializePerson();
        System.out.println(person.toString());

    }

    /**
     * 序列化
     */
    private static void serializePerson() throws IOException {
       Person person=new Person("刘军建","123#");

        // ObjectOutputStream 对象输出流，将 person 对象存储到E盘的 flyPig.txt 文件中，完成对 person对象的序列化操作
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/person.txt")));
        oos.writeObject(person);
        System.out.println("person 对象序列化成功！");
        oos.close();
    }

    /**
     * 反序列化
     */
    private static Person deserializePerson() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:/person.txt")));
       Person person = (Person) ois.readObject();
        System.out.println("person 对象反序列化成功！");
        return person;
    }

}
