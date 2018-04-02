package com.tasktwo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * student的模型
 * Created by Administrator on 25/7/2017.
 */
public class Student {

    String userId;
    String name;
    //1为JAVA，2为CSS，3为PM
    int studyType;
    int qq;
    Long entryData;
    String graduated;
    String url;
    String wish;
    String knowFrom;
    long createAt;
    long updateAt;

    public void Student(String userId,String name,int studyType,int qq,long entryData,String graduated,
                        String url,String wish,String knowFrom,long createAt,long updateAt){
        this.userId = userId;
        this.name = name;
        this.studyType = studyType;
        this.qq = qq;
        this.entryData = entryData;
        this.graduated = graduated;
        this.url = url;
        this.wish = wish;
        this.knowFrom = knowFrom;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyType(int studyType) {
        this.studyType = studyType;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public void setentryData(long entryData){
        this.entryData = entryData;
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

    public void setKnowFrom(String knowFrom){
        this.knowFrom = knowFrom;
    }

    public void setCreateAt(long createAt){
        this.createAt = createAt;
    }

    public void setUpdateAt(long updateAt){
        this.updateAt = updateAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() { return name; }

    public int getStudyType() {
        return studyType;
    }

    public int getQq() {
        return qq;
    }

    public long getEntryData() {
        return entryData;
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

    public String getKnowFrom(){
        return knowFrom;
    }

    public long getCreateAt(){
        return createAt;
    }

    public long getUpdateAt(){
        return updateAt;
    }

    @Override
    public String toString(){


        //把long转为Date性
//        Date date = new Date(entryData);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateNowStr = sdf.format(date);
        return  "Student [userId = " + userId + ", name = " + name + ", studtType = " + studyType +
                ", qq = " + qq + ", entryData = " + entryData + ", graduated = " + graduated +
                "\n\t\t url = "+ url + ", wish = " + wish + ", knowFrom = "+ knowFrom +
                ", createAt = "+ createAt + ", updateAt = " + updateAt + "]\n";
    }
}
