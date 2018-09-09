package com.jnshu;

public class Student {
    private long id;
    private String name;
    private int number;
    private int qq;
    private String coachName;
    private String dailyLink;
    private String gradeColleage;
    private long create_at;
    private long update_at;
    public Student(){
    }
    public Student(String name, int number, int qq, String coachName, String dailyLink, String gradeColleage){
        this.name = name;
        this.number = number;
        this.qq = qq;
        this.coachName = coachName;
        this.dailyLink = dailyLink;
        this.gradeColleage = gradeColleage;
    }

    public Student(long id, String name, int number, int qq, String coachName, String dailyLink, String gradeColleage, long create_at, long update_at){
        this.id = id;
        this.name = name;
        this.number = number;
        this.qq = qq;
        this.coachName = coachName;
        this.dailyLink = dailyLink;
        this.gradeColleage = gradeColleage;
        this.create_at = create_at;
        this.update_at = update_at;
    }
    public Student(String name, int number, int qq, String coachName, String dailyLink, String gradeColleage, long create_at, long update_at){
        this.name = name;
        this.number = number;
        this.qq = qq;
        this.coachName = coachName;
        this.dailyLink = dailyLink;
        this.gradeColleage = gradeColleage;
        this.create_at = create_at;
        this.update_at = update_at;
    }
    public Student(long id,String name, int number, int qq, String coachName, String dailyLink, String gradeColleage,long update_at){
        this.id = id;
        this.name = name;
        this.number = number;
        this.qq = qq;
        this.coachName = coachName;
        this.dailyLink = dailyLink;
        this.gradeColleage = gradeColleage;
        this.update_at = update_at;
    }
    public Student(long id, String name, int number, int qq, String coachName, String dailyLink, String gradeColleage){
        this.id = id;
        this.name = name;
        this.number = number;
        this.qq = qq;
        this.coachName = coachName;
        this.dailyLink = dailyLink;
        this.gradeColleage = gradeColleage;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getName(){
       return name ;
    }
    public void setName(String name){
        this.name = name ;
    }

    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
       this.number = number;
    }

    public int getQq(){
        return qq;
    }
    public void setQq(int qq){
        this.qq = qq;
    }

    public String getCoachName(){
        return coachName;
    }
    public void setCoachName(String coachName){
        this.coachName = coachName;
    }

    public String getDailyLink(){
        return dailyLink;
    }
    public void setDailyLink(String dailyLink){
        this.dailyLink = dailyLink;
    }

    public String getGradeColleage(){
        return gradeColleage;
    }
    public void setGradeColleage(String gradeColleage){
        this.gradeColleage = gradeColleage;
    }

    public long getCreateAt(){
        return create_at;
    }
    public void setCreateAt(long creat_at){
        this.create_at = creat_at;
    }

    public long getUpdateAt(){
        return update_at;
    }
    public void setUpdateAt(long update_at){
        this.create_at = update_at;
    }

    @Override
public String toString(){
     return "Student{"+ "id：" + id  +  ",name：" + name +",number：" + number + ",qq：" + qq + ",coachName：" + coachName + ",dailyLink：" + dailyLink + ",gradeColleage：" + gradeColleage +",create_at：" + create_at + "update_at："+update_at + '}'+"\n";
}
}
