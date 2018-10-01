package com.demo;

import com.pojo.User;

import java.io.*;

public class Demo1 {
    /**
     * 序列化
     */
    private void serialize() {
        User user = new User();
        user.setName("刘军鹏");
        user.setAge("28");
        try {
            // ObjectOutputStream 对象输出流，将 flyPig 对象存储到E盘的 flyPig.txt 文件中，完成对 flyPig 对象的序列化操作
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("user.txt")));
            oos.writeObject(user);
            System.out.println("User对象序列化成功！");
            oos.close();
        } catch (IOException e) {
            System.out.println("序列化失败！");
        }
    }

    /**
     * 反序列化
     */
    private void deserialize() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user.txt")));
            User user = (User) ois.readObject();
            System.out.println("User对象反序列化成功！");
            System.out.println(user.getName() + "享年" + user.getAge() + "!");
        } catch (Exception e) {
            System.out.println("反序列化失败！");
        }
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        demo.serialize();
        demo.deserialize();
    }
}
