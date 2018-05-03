package com.task.models;

public class Person{
    private int id;
    private String name ;
    private int fightingCapacity;
    private String uniqueSkill ;
    private Long createdAt;
    private Long updatedAt;

    public  Person(){}


    public Person(int id,long updatedAt,String name, int fightingCapacity, String uniqueSkill) {
        this.id = id;
        this.updatedAt=updatedAt;
        this.name = name;
        this.fightingCapacity = fightingCapacity;
        this.uniqueSkill = uniqueSkill;
    }

    public Person(Long createdAt,String name, int fightingCapacity, String uniqueSkill) {
        this.createdAt=createdAt;
        this.name = name;
        this.fightingCapacity = fightingCapacity;
        this.uniqueSkill = uniqueSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFightingCapacity() {
        return fightingCapacity;
    }

    public void setFightingCapacity(int fightingCapacity) {
        this.fightingCapacity =fightingCapacity;
    }

    public String getUniqueSkill() {
        return uniqueSkill;
    }
    public void setUniqueSkill(String uniqueSkill) {
        this.uniqueSkill =uniqueSkill;
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
@Override
    public String toString() {
        return "Person{"+"id="+id+",name="+name+",fightingCapacity="+fightingCapacity+",uniqueSkill="+uniqueSkill+"}";
    }
}