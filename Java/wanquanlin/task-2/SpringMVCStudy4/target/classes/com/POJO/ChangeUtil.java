package com.POJO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeUtil {
    public static DateTypeChange1 dateTypeChange(Student s) {
    DateTypeChange1 dtc=new DateTypeChange1();
    dtc.setID(s.getID());
    dtc.setName(s.getName());
    dtc.setQQ(s.getQQ());
    dtc.setOnlineID(s.getOnlineID());
    dtc.setGraduate_institutions(s.getGraduate_institutions());
    dtc.setReport_link(s.getReport_link());
    dtc.setSwear(s.getSwear());
    dtc.setHearfrom(s.getHearfrom());
    //毕业时间类型转换转换Long转换到Date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timechange1=sdf.format(s.getTime_of_enrollment());
    dtc.setTime_of_enrollment(timechange1);
    //创建时间类型转换Long转换到Date
//   SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
  /*  String timechange2 = sdf.format(s.getCreate_at());
    dtc.setCreate_at(timechange2);
    //更新时间类型转换Long转换到Date
//   SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    String timechange3 = sdf.format(s.getUpdate_at());
    dtc.setUpdate_at(timechange3);*/
    return dtc;
    }
    public static Student LongTypeChange(DateTypeChange1 s) throws ParseException {
        Student dtc = new Student();
        dtc.setID(s.getID());
        dtc.setName(s.getName());
        dtc.setQQ(s.getQQ());
        dtc.setOnlineID(s.getOnlineID());
        dtc.setGraduate_institutions(s.getGraduate_institutions());
        dtc.setReport_link(s.getReport_link());
        dtc.setSwear(s.getSwear());
        dtc.setHearfrom(s.getHearfrom());
        //毕业时间类型转换Date转换到Long
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Long timechange1=sdf1.parse(s.getTime_of_enrollment()).getTime();
        dtc.setTime_of_enrollment(timechange1);
        //创建时间类型转换转换Date转换到Long
/*        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Long timechange2=sdf1.parse(s.getCreate_at()).getTime();
        dtc.setCreate_at(timechange2);
        //更新时间类型转换转换Date转换到Long
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        Long timechange3=sdf1.parse(s.getUpdate_at()).getTime();
        dtc.setUpdate_at(timechange3);*/
        return dtc;
    }
/*    public static Student LongTypeChange2(DateTypeChange1 s) throws ParseException {
        Student dtc = new Student();
        //创建时间类型转换转换Date转换到Long
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Long timechange2=sdf1.parse(s.getCreate_at()).getTime();
        dtc.setCreate_at(timechange2);
        //更新时间类型转换转换Date转换到Long
        Long timechange3=sdf1.parse(s.getUpdate_at()).getTime();
        dtc.setUpdate_at(timechange3);
        return dtc;
    }*/
}
