package com.spring_mybatis.Category;

public class Category {
    private int id;
    private String name;
    private int getId(){return id;}
    public void setId(int id){ this.id = id;}
    public String getName(){ return  name; }
    public void setName(String name){ this.name = name; }

    @Override
    public String toString(){ return "Category [id=" + id +",name=" + name +"]" ;}


}
