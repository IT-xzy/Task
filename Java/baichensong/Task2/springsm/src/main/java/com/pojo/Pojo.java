package com.pojo;
// 测试 接口用 。。



public class Pojo {
private int id;
private String name;

   public  int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String  toString(){
        return "Pojo{id ="+id+",name = "+name+"}";
    }
}