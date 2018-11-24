package com.ptteng.serializableTest;

import java.io.*;


public class serializableTest {

    //序列化和反序列化
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializePerson();
        Person person = deserializePerson();
        System.out.println(person.toString());
    }


    //序列化方法
    private static void serializePerson() throws IOException {
        Person person = new Person();
        person.setName("郭小杰");
        person.setAge(23L);
        person.setSex("男");
/*ObjectOutputStream 对象输出流，将 person对象存储到E盘的 person.txt 文件中，
完成对person 对象的序列化操作*/
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("e:/person.txt")));
        oos.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oos.close();
    }


    //反序列化方法
    private static Person deserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("e:/person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功");
        return person;
    }


}
