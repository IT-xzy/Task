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
    
    /**
     * 反射版本通用转换
     * @param o
     * @return
     */
//    public static Object change(Object o) {
//        Class c = o.getClass();
//        String time = "enrollmentTime";
//        try {
//
//            Field field = c.getDeclaredField(time);
//            Field[] arr = c.getDeclaredFields();
//            field.setAccessible(true);
//            if (field.get(o) instanceof String) {
//                Class c1 = Student.class;
//                Student s = (Student) c1.newInstance();
//                Field field1 = c1.getDeclaredField(time);
//                field1.setAccessible(true);
//                field1.set(s,new SimpleDateFormat("yyyy-MM-dd").parse((String)field.get(o)).getTime());
//                Field[] arr1 = c1.getDeclaredFields();
//                for (Field fieldo : arr) {
//                    fieldo.setAccessible(true);
//                    for (Field fields : arr1) {
//                        fields.setAccessible(true);
//                        if (!fieldo.getName().equals(time) && fieldo.getName().equals(fields.getName())) {
//                            fields.set(s, fieldo.get(o));
//                        }
//                    }
//                }
//                return s;
//            }
//
//            if (field.get(o) instanceof Long) {
//                Class c1 = DateTypeChange1.class;
//                DateTypeChange1 sp = (DateTypeChange1) c1.newInstance();
//                Field field1 = c1.getDeclaredField(time);
//                field1.setAccessible(true);
//                field1.set(sp, new SimpleDateFormat("yyyy年MM月dd日").format(field.get(o)));
//                Field[] arr1 = c1.getDeclaredFields();
//                for (Field fieldo : arr) {
//                    fieldo.setAccessible(true);
//                    for (Field fields : arr1) {
//                        fields.setAccessible(true);
//                        if (!fieldo.getName().equals(time) && fieldo.getName().equals(fields.getName())) {
//                            fields.set(sp, fieldo.get(o));
//                        }
//                    }
//                }
//                return sp;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
