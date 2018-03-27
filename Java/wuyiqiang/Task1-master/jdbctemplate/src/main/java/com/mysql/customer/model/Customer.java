package com.mysql.customer.model;

public class Customer {

    private int custID;
    private String name;
    private int age;

    public Customer(){

    }

    public Customer(int custID, String name, int age) {
        this.custID = custID;
        this.name = name;
        this.age = age;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getCustID() {
        return  this.custID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}
