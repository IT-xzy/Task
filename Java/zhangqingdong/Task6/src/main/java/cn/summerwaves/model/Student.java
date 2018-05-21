package cn.summerwaves.model;


import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by summerwaves on 2017/9/9.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -3896605600471191953L;

    private int id;
    private String name;
    private String QQ;
    private String type;
    private String appointment;
    private String school;
    private String number;
    private String link;
    private String oath;
    private String supportSenior;
    private String referrer;
    private String source;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", QQ='" + QQ + '\'' +
                ", type='" + type + '\'' +
                ", appointment=" + appointment +
                ", school='" + school + '\'' +
                ", number='" + number + '\'' +
                ", link='" + link + '\'' +
                ", oath='" + oath + '\'' +
                ", supportSenior='" + supportSenior + '\'' +
                ", referrer='" + referrer + '\'' +
                ", source='" + source + '\'' +
                '}';
    }



    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    public String getSupportSenior() {
        return supportSenior;
    }

    public void setSupportSenior(String supportSenior) {
        this.supportSenior = supportSenior;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }



}
