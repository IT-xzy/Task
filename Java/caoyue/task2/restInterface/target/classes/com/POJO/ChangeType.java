package com.POJO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ChangeType {
        public static DateTypeChange1 dateTypeChange1(Student s) {
            DateTypeChange1 dtc=new DateTypeChange1();
            dtc.setID(s.getID());
            dtc.setName(s.getName());
            dtc.setQQ(s.getQQ());
            dtc.setOnlineNumber(s.getOnlineNumber());
            dtc.setProfessionType(s.getProfessionType());
            dtc.setDailyLink(s.getDailyLink());
            dtc.setPromise(s.getPromise());
            dtc.setBrotherName(s.getBrotherName());
            dtc.setPhone(s.getPhone());
            dtc.setMail(s.getMail());
            //毕业时间类型转换转换Long转换到Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String timechange1=sdf.format(s.getEnrollmentTime());
            dtc.setEnrollmentTime(timechange1);
            return dtc;
        }
        public static Student LongTypeChange(DateTypeChange1 s) throws ParseException {
            Student dtc = new Student();
            dtc.setID(s.getID());
            dtc.setName(s.getName());
            dtc.setQQ(s.getQQ());
            dtc.setOnlineNumber(s.getOnlineNumber());
            dtc.setProfessionType(s.getProfessionType());
            dtc.setDailyLink(s.getDailyLink());
            dtc.setPromise(s.getPromise());
            dtc.setBrotherName(s.getBrotherName());
            dtc.setPhone(s.getPhone());
            dtc.setMail(s.getMail());
            //毕业时间类型转换Date转换到Long
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            Long timechange1=sdf1.parse(s.getEnrollmentTime()).getTime();
            dtc.setEnrollmentTime(timechange1);
            return dtc;
        }
}
