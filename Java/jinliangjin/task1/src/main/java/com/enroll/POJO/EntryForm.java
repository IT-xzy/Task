package com.enroll.POJO;

import java.util.List;

/**
 * @ProjectName: task1
 * @Package: com.enroll.POJO
 * @ClassName: EntryForm
 * @Description: 报名表
 * @Author: Jin
 * @CreateDate: 2018/4/27 11:28
 * @UpdateUser:
 * @UpdateDate: 2018/4/27 11:28
 * @UpdateRemark:
 * @Version: 1.0
 */

public class EntryForm {
    private int id;
    private String name;
    private String sex;
    private int qq;
    private String whatType;
    private Long joinTime;
    private String school;
    private String student_id;
    private String link;
    private String wishes;
    private String tutorBro;
    private String knowFrom;
    List<EntryForm> entryForms;

    /*    public String test = "123456";
        private String test1 = "123456";*/
    public EntryForm() {
    }
/*    public EntryForm(String name){
        this.name = name;
    }
    public EntryForm(String name, int qq){
        this.name = name;
        this.qq = qq;
    }
    public EntryForm(int qq, String name){
        this.qq = qq;
        this.name = name;
    }*/

    /**
     * @Description: no id
     * 〈〉
     * * @param name
     * @return:
     * @since: 1.0.0
     * @Date:
     */

    public EntryForm(String name, String sex, int qq, String whatType, Long joinTime, String school,
                     String student_id, String link, String wishes, String tutorBro, String knowFrom) {

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
    }

    public EntryForm(int id, String name, String sex, int qq, String whatType, Long joinTime, String school,
                     String student_id, String link, String wishes, String tutorBro, String knowFrom) {
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
    }

    @Override
    public String toString() {
        return "编号：" + id + "，姓名：" + name + "，性别：" + sex + "，QQ：" + qq + "，修真类型：" + whatType +
                "，入学时间：" + joinTime + "毕业院校：" + school + "，学号：" + student_id + "，日报连接：" + link +
                "，许愿：" + wishes + "，师兄：" + tutorBro + "，从何处了解到修真院：" + knowFrom;
    }
/*    private Boolean reflect(String str){
        if(str.equals("123456")){
            return true;
        }
        else return false;
    }*/

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

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
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

    public List<EntryForm> getEntryForms() {
        return entryForms;
    }

    public void setEntryForms(List<EntryForm> entryForms) {
        this.entryForms = entryForms;
    }
}
