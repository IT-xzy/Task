package com.POJO;

public class DateTypeChange1 {
    private Integer ID;
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
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    
    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }
    
    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }
    
    public void setQQ(int QQ) {
        this.QQ = QQ;
    }
    
    public void setOnlineNumber(String onlineNumber) {
        this.onlineNumber = onlineNumber;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public void setEnrollmentTime(String enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }
    
    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }
    
    public void setBrotherName(String brotherName) {
        this.brotherName = brotherName;
    }
    
    public void setPromise(String promise) {
        this.promise = promise;
    }
    
    public Integer getID() {
        return ID;
    }
    
    public String getCreate_at() {
        return create_at;
    }
    
    public String getUpdate_at() {
        return update_at;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDailyLink() {
        return dailyLink;
    }
    
    public int getQQ() {
        return QQ;
    }
    
    public String getOnlineNumber() {
        return onlineNumber;
    }
    
    public String getMail() {
        return mail;
    }
    
    public int getPhone() {
        return phone;
    }
    
    public String getEnrollmentTime() {
        return enrollmentTime;
    }
    
    public String getProfessionType() {
        return professionType;
    }
    
    public String getBrotherName() {
        return brotherName;
    }
    
    public String getPromise() {
        return promise;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", QQ=" + QQ +
                ", onlineNumber='" + onlineNumber + '\'' +
                ", enrollmentTime=" + enrollmentTime +
                ", professionType='" + professionType + '\'' +
                ", dailyLink='" + dailyLink + '\'' +
                ", promise='" + promise + '\'' +
                ", brotherName='" + brotherName + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
