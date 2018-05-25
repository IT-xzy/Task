package com.xiuzhenyuan.task1.tool;

import com.xiuzhenyuan.task1.model.StudentDO;
import org.springframework.stereotype.Component;

@Component("printFormat")
public class PrintFormat {
    public void printf(StudentDO studentDO){
        System.out.println("==============Student ID" + studentDO.getAddId() + "==============");
        System.out.println("姓名: " + studentDO.getName());
        System.out.println("QQ: " + studentDO.getQq());
        System.out.println("修真类型: " + studentDO.getType());
        System.out.println("预计入学时间: " + studentDO.getEntorTime());
        System.out.println("毕业学校: " + studentDO.getGraduateSchool());
        System.out.println("线上学号: " + studentDO.getNetId());
        System.out.println("日报连接: " + studentDO.getDailyLink());
        System.out.println("立愿: " + studentDO.getWish());
        System.out.println("师兄: " + studentDO.getSenior());
        System.out.println("创建时间: " + studentDO.getCreateTime());
        System.out.println("修改时间: " + studentDO.getUpdateTime());
    }
}
