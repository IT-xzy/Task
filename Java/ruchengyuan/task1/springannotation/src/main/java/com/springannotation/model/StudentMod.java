package com.springannotation.model;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 16/7/2017.
 * 定义了一个student的类，类成员变量包含id,name,study_type,qq,entrydata
 * 类成员方法有变量的set和get方法和自定义的构造方法，toString方法
 */


public class StudentMod {

    String user_id;
    String name;
    int study_type;//1表示JAVA，2为CSS，3为PM
    int qq;
    Long entry_data;
    String graduated;
    String url;
    String wish;
    String know_from;
    long create_at;
    long update_at;

    /*
     * 重新定义构造方法
     */
    public void studentMod(String user_id,String name,int study_type,int qq,long entry_data,String graduated,
                           String url,String wish,String know_from,long create_at,long update_at){

        this.user_id = user_id;
        this.name = name;
        this.study_type = study_type;
        this.qq = qq;
        this.entry_data = entry_data;
        this.graduated = graduated;
        this.url = url;
        this.wish = wish;
        this.know_from = know_from;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    //类成员变量的Set与get方法
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudy_type(int study_type) {
        this.study_type = study_type;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public void setEntry_data(long entry_data){
        this.entry_data = entry_data;
    }

    public void setGraduated(String graduated){
        this.graduated = graduated;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setWish(String wish){
        this.wish = wish;
    }

    public void setKnow_from(String know_from){
        this.know_from = know_from;
    }

    public void setCreate_at(long create_at){
        this.create_at = create_at;
    }

    public void setUpdate_at(long update_at){
        this.update_at = update_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() { return name; }

    public int getStudy_type() {
        return study_type;
    }

    public int getQq() {
        return qq;
    }

    public long getEntry_data() {
        return entry_data;
    }

    public String getGraduated(){
        return graduated;
    }

    public String getUrl(){
        return url;
    }

    public String getWish(){
        return  wish;
    }

    public String getKnow_from(){
        return know_from;
    }

    public long getCreate_at(){
        return create_at;
    }

    public long getUpdate_at(){
        return update_at;
    }

    //重构toString方法
    @Override
    public String toString(){

        /*
         * 把时间戳entrydata转换为string类型dateNowStr输出
         */
        Date date = new Date(entry_data);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(date);

        return  "Student [user_id = " + user_id + ", name = " + name + ", study_type = " + study_type +
                ", qq = " + qq + ", entrydata = " + dateNowStr + ", graduated = " + graduated +
                "\n\t\t url = "+ url + ", wish = " + wish + ", know_from = "+ know_from +
                ", create_at = "+ create_at + ", update_at = " + update_at + "]";
    }
}
