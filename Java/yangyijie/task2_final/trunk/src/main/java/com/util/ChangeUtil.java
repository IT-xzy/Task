package com.util;

import com.bean.Student;
import com.bean.StudentGet;
import com.bean.StudentPut;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arike
 * Create_at 2017/12/14 14:26
 */
public class ChangeUtil {
    private ChangeUtil(){}
    public static Student studentChange(StudentGet sg){
        Student s = new Student();
        s.setBro(sg.getBro());
        s.setDaily_link(sg.getDaily_link());
        s.setDesire(sg.getDesire());
        s.setQQ(sg.getQQ());
        s.setMajor(sg.getMajor());
        s.setGra_school(sg.getGra_school());
        s.setOnline_id(sg.getOnline_id());
        s.setKnow_from(sg.getKnow_from());
        Long time = sg.getEntry_time().getTime();
        s.setEntry_time(time);
        s.setName(sg.getName());
        return s;
    }
    
    
    public static StudentPut timeChange(Student s){
        StudentPut sp = new StudentPut();
        sp.setId(s.getId());
        sp.setBro(s.getBro());
        sp.setDaily_link(s.getDaily_link());
        sp.setDesire(s.getDesire());
        sp.setQQ(s.getQQ());
        sp.setMajor(s.getMajor());
        sp.setGra_school(s.getGra_school());
        sp.setOnline_id(s.getOnline_id());
        sp.setKnow_from(s.getKnow_from());
        sp.setName(s.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String time = sdf.format(s.getEntry_time());
        sp.setEntry_time(time);
        return sp;
    }
}
