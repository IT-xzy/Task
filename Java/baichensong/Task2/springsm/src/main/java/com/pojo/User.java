package com.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private String qq;
    private String kemu;
    private  String startTime;
    private  String school;
    private  int xuehao;
    private  String ribao;
    private  String xinyuan;
    private  String shixiong ;
    private Timestamp created_at;
    private  Timestamp updated_at;

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
    public String getQq(){
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getKemu(){
        return kemu;
    }
    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public  String getStartTime(){
        return  startTime;
    }
    public void  setStartTime(String startTime){
        this.startTime=startTime;
    }

    public  String getSchool(){
        return  school;
    }
    public void  setSchool( String school){
        this.school=school;
    }

    public  int getXuehao(){
        return  xuehao;
    }
    public void setXuehao(int xuehao){
        this.xuehao = xuehao;
    }

    public  String getRibao(){return  ribao;}
    public void  setRibao(String ribao){this.ribao=ribao;}

    public  String getXinyuan(){return  xinyuan;}
    public void  setXinyuan(String xinyuan){this.xinyuan=xinyuan;}
    public  String getShixiong(){return  shixiong;}
    public void  setShixiong(String shixiong){this.shixiong=shixiong;}

    public Timestamp getCreated_at(){
        return created_at;
    }
    public void setCreated_at (Timestamp created_at){
        this.created_at = created_at;
    }
    public Timestamp getUpdated_at(){return updated_at;}
    public void setUpdated_at(Timestamp updated_at){
        this.updated_at = updated_at;
    }


    //输出显示

    public String toString() {
        return "User{id= "+id+",name="+name+",qq="+qq+",kemu="+kemu+"," +
                "startTime="+startTime+",school="+school+"," +
                "xuehao="+xuehao+",ribao="+ribao+",xinyuan="+xinyuan+"," +
                "shixiong="+shixiong+",created_at="+created_at+",updated_at="+updated_at+"}";


    }
}




