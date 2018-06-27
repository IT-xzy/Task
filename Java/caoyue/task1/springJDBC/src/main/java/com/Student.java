package com;

public class Student {
    private int ID;
    private String create_at;
    private String update_at;
    private String name;
    private String dailyLink;
    private int QQ;
    private String onlineNumber;
    private String mail;
    private int phone;
    private String enrollmentTime;
    private String professionType;
    private String brotherName;
    private String promise;
    
    @Override
    public String toString() {
        return "student{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
    
    public Integer getId() {
        return ID;
    }
    public void setId(Integer ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCreate_at() {
        return create_at;
    }
    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    
    public String getUpdate_at() {
        return update_at;
    }
    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }
    
    public String getDailyLink() {
        return dailyLink;
    }
    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }
    
    public String getOnlineNumber() {
        return onlineNumber;
    }
    public void setOnlineNumber(String onlineNumber) {
        this.onlineNumber = onlineNumber;
    }
    
    public String getEnrollmentTime() {
        return enrollmentTime;
    }
    public void setEnrollmentTime(String enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }
    
    public String getProfessionType() {
        return professionType;
    }
    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }
    
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getBrotherName() {
        return brotherName;
    }
    public void setBrotherName(String brotherName) {
        this.brotherName = brotherName;
    }
    
    public String getPromise() {
        return promise;
    }
    public void setPromise(String promise) {
        this.promise = promise;
    }
    
    public int getQQ() {
        return QQ;
    }
    public void setQQ(int QQ) {
        this.QQ = QQ;
    }
    
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
