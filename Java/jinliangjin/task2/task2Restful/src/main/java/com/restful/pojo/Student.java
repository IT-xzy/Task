package com.restful.pojo;

import com.restful.dao.Validate1;
import com.restful.dao.Validate2;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.pojo
 * @ClassName: Student
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:17
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:17
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Student {
    //integer整数位数上限，fraction小数位数上限。
    @Digits(integer = 6, fraction = 0, message = "{student.id.error}", groups = {Validate1.class, Validate2.class})
    private int id;
    @Size(min = 1, max = 8, message = "{student.name.length.error}", groups = Validate2.class)
    private String name;
    private String sex;
    private Long qq;
    private String whatType;
    private Long joinTime;
    private String school;
    private String student_id;
    @URL(message = "{student.url.error}", groups = Validate2.class)
    private String link;
    private String wishes;
    private String tutorBro;
    private String knowFrom;
    private Long create_at;
    private Long update_at;

    public Student() {
    }

    public Student(String name, String sex, Long qq, String whatType, Long joinTime, String school, String student_id,
                   String link, String wishes, String tutorBro, String knowFrom, Long create_at, Long update_at) {
        this.name = name;
        this.sex = sex;
        this.qq = qq;
        this.whatType = whatType;
        this.joinTime = joinTime;
        this.school = school;
        this.student_id = student_id;
        this.link = link;
        this.wishes = wishes;
        this.tutorBro = tutorBro;
        this.knowFrom = knowFrom;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Student(int id, String name, String sex, Long qq, String whatType, Long joinTime, String school, String
            student_id, String link, String wishes, String tutorBro, String knowFrom, Long create_at, Long update_at) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.qq = qq;
        this.whatType = whatType;
        this.joinTime = joinTime;
        this.school = school;
        this.student_id = student_id;
        this.link = link;
        this.wishes = wishes;
        this.tutorBro = tutorBro;
        this.knowFrom = knowFrom;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "编号：" + id + "，姓名：" + name + "，性别：" + sex + "，QQ：" + qq + "，修真类型：" + whatType +
                "，入学时间：" + joinTime + "毕业院校：" + school + "，学号：" + student_id + "，日报连接：" + link +
                "，许愿：" + wishes + "，师兄：" + tutorBro + "，从何处了解到修真院：" + knowFrom + "，创建时间：" +
                create_at + "，更新时间：" + update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getWhatType() {
        return whatType;
    }

    public void setWhatType(String whatType) {
        this.whatType = whatType;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public String getTutorBro() {
        return tutorBro;
    }

    public void setTutorBro(String tutorBro) {
        this.tutorBro = tutorBro;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }
}
