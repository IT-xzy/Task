package jnshu.util;

import jnshu.pojo.StudentInfo;

import java.util.List;

public class AddPageCount {

    public static List<StudentInfo> setCount(List<StudentInfo>studentInfos,int pageCount){
        studentInfos.forEach(x->x.setPageCount(pageCount));
        return studentInfos;
    }
}
