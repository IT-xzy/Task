package com.hzw.pojo;


public class Student {
    private long s_id;
    private String s_name;
    private int s_qq;
    private String s_type;
    private int s_num;
    private long create_at;
    private long update_at;

    public void Student(){
    }

    public void Student(String s_name,int s_num){
        this.s_name = s_name;
        this.s_num = s_num;
    }

    public void Student(String s_name,int s_qq,String s_type,int s_num,long update_at){
        this.s_name = s_name;
        this.s_qq = s_qq;
        this.s_type = s_type;
        this.s_num = s_num;
        this.update_at = update_at;
    }

    public void Student(String s_name,int s_qq,String s_type,int s_num,long create_at,long update_at){
        this.s_name = s_name;
        this.s_qq = s_qq;
        this.s_type = s_type;
        this.s_num = s_num;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public void Student(long s_id,String s_name,int s_qq,String s_type,int s_num,long create_at,long update_at){
        this.s_name = s_name;
        this.s_qq = s_qq;
        this.s_type = s_type;
        this.s_num = s_num;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getS_qq() {
        return s_qq;
    }

    public void setS_qq(int s_qq) {
        this.s_qq = s_qq;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public int getS_num() {
        return s_num;
    }

    public void setS_num(int s_num) {
        this.s_num = s_num;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Student[ id = " + s_id + "," +
                " name = " + s_name + "," +
                " qq = " + s_qq + "," +
                " type = " + s_type + "," +
                " num = " + s_num + "," +
                " create_at = " + create_at + "," +
                " update_at = " + update_at + "]\n";
    }
}
