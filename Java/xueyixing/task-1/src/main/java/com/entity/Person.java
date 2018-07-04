package com.entity;

public class Person{
    private int id;
    private String name;
    private String QQ;
    private String iesson_type;
    private String Enroiment_time;
    private String Graduated_school;
    private int student_ID;
    private String Daily_conection;
    private String wish;
    private String brother_name;
    private String Channel;

    public int getId(){
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
    public String getQQ() {
        return QQ;
    }
    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
    public String getIesson_type() {
        return iesson_type;
    }
    public void setIesson_type(String iesson_type) {
        this.iesson_type = iesson_type;
    }
    public String getEnroiment_time() {
        return Enroiment_time;
    }
    public void setEnroiment_time(String Enroiment_time) {
        this.Enroiment_time = Enroiment_time;
    }
    public String getGraduated_school() {
        return Graduated_school;
    }
    public void setGraduated_school(String Graduated_school) {
        this.Graduated_school = Graduated_school;
    }
    public int getStudent_ID() {
        return student_ID;
    }
    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }
    public String getDaily_conection() {
        return Daily_conection;
    }
    public void setDaily_conection(String Daily_conection) {
        this.Daily_conection = Daily_conection;
    }
    public String getWish() {
        return wish;
    }
    public void setWish(String wish) {
        this.wish = wish;
    }
    public String getBrother_name() {
        return brother_name;
    }
    public void setBrother_name(String brother_name) {
        this.brother_name = brother_name;
    }
    public String getChannel() {
        return Channel;
    }
    public void setChannel(String Channel) {
        this.Channel = Channel;
    }

    public Person(){}
    public Person(String name,String QQ, String iesson_type,
                  String Enroiment_time, String Graduated_school, int student_ID, String Daily_conection,
                  String wish, String brother_name, String Channel) {
        super();
        this.name = name;
        this.QQ = QQ;
        this.iesson_type = iesson_type;
        this.Enroiment_time = Enroiment_time;
        this.Graduated_school = Graduated_school;
        this.student_ID = student_ID;
        this.Daily_conection = Daily_conection;
        this.wish = wish;
        this.brother_name = brother_name;
        this.Channel = Channel;
    }

    public Person(int id, String name, String QQ, String iesson_type,
                  String Enroiment_time, String Graduated_school, int student_ID, String Daily_conection,
                  String wish, String brother_name, String Channel) {
        super();
        this.id = id;
        this.name = name;
        this.QQ = QQ;
        this.iesson_type = iesson_type;
        this.Enroiment_time = Enroiment_time;
        this.Graduated_school = Graduated_school;
        this.student_ID = student_ID;
        this.Daily_conection = Daily_conection;
        this.wish = wish;
        this.brother_name = brother_name;
        this.Channel = Channel;
    }

    @Override
    public String toString(){
        return "User(id = " + id + ",name = " + name +", QQ=" + QQ + ", iesson_type=" + iesson_type +", Enroiment_time=" + Enroiment_time + ", Graduated_school=" + Graduated_school + ", student_ID=" + student_ID + ", Daily_conection=" + Daily_conection + ", wish=" + wish + ", brother_name=" + brother_name + ", Channel=" + Channel + ")";
    }
}
