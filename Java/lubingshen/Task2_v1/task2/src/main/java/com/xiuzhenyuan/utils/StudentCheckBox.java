/*
对应的mysql建表语句：
create table if not exists`students`(
`name` varchar(10) not null,
`QQ` varchar(15) not null,
`type` varchar(10) not null,
`admission_time` varchar(20) not null,
`school` varchar(10) not null,
`num` varchar(10) not null,
`daily` varchar(100) not null,
`declaration` varchar(50) not null,
`elder` varchar(30) not null,
`knew_from` varchar(10) not null,
`ID` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
primary key(`id`),
index (`name`),
unique `online`(`num`)
)engine = innodb default charset = utf8;
 */
package com.xiuzhenyuan.utils;

import com.xiuzhenyuan.bean.Student;

public class StudentCheckBox {

    //对于student的内容限制，可以在这里设置
    //如果需要返回更详细的信息，可以设置返回值为int;
    public static boolean checkStudent(Student student){
        if(student.getName().length()>8)
            return false;
        if(student.getQQ().length()>13)
            return false;
        if (student.getType().length()>8)
            return false;
        if(student.getAdmissionTime().length()>18)
            return false;
        if (student.getSchool().length()>8)
            return false;
        if (student.getDaily().length()>90)
            return false;
        if(student.getDeclaration().length()>40)
            return false;
        if(student.getElder().length()>8)
            return false;
        if(student.getKnewFrom().length()>8)
            return false;
        return true;
    }
}
