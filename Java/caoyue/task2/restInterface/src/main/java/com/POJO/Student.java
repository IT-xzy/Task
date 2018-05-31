package com.POJO;

public class Student {
    private Integer ID;
    private Long create_at;
    private Long update_at;
    private String name;
    private String dailyLink;
    private int QQ;
    private String onlineNumber;
    private String mail;
    private int phone;
    private Long enrollmentTime;
    private String professionType;
    private String brotherName;
    private String promise;
    
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
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDailyLink() {
        return dailyLink;
    }
    
    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }
    
    public int getQQ() {
        return QQ;
    }
    
    public void setQQ(int QQ) {
        this.QQ = QQ;
    }
    
    public String getOnlineNumber() {
        return onlineNumber;
    }
    
    public void setOnlineNumber(String onlineNumber) {
        this.onlineNumber = onlineNumber;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public int getPhone() {
        return phone;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public Long getEnrollmentTime() {
        return enrollmentTime;
    }
    
    public void setEnrollmentTime(Long enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }
    
    public String getProfessionType() {
        return professionType;
    }
    
    public void setProfessionType(String professionType) {
        this.professionType = professionType;
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
}
