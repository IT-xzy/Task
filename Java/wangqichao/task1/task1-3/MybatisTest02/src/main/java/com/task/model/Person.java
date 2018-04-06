package com.task.model;

public class Person {
    private int id;
    private String name ;
    private int age ;
    private String personID ;
    private Long createdAt;
    private Long updatedAt;

    public  Person(){}
    public  Person(String name, int age, String personID){
        this.name = name;
        this.age = age;
        this.personID = personID;
    }
    public  Person(int id,String name, int age, String personID){
        this.id=id;
        this.name = name;
        this.age = age;
        this.personID = personID;
    }

    public Person(int id,long updatedAt,String name, int age, String personID) {
        this.id = id;
        this.updatedAt=updatedAt;
        this.name = name;
        this.age = age;
        this.personID = personID;
    }

    public Person(Long createdAt,String name, int age, String personID) {
        this.createdAt=createdAt;
        this.name = name;
        this.age = age;
        this.personID = personID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPersonID() {
        return personID;
    }
    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Long createdAt){
        this.createdAt=createdAt;
    }
    public Long getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(Long updatedAt){
        this.updatedAt=updatedAt;
    }

    public String toString() {
        return "Person{"+"id="+id+",name="+name+",age="+age+",personID="+personID+"}";
    }
}
