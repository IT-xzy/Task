package cn.wyq.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;

    public int id;
    public String name;
    public String type;
    public String school;
    public String pledge;
    public int createTime;
    public int updateTime;
    public int siblingId;
    public String siblingName;
    public String telephone;
    public String email;
    public String photo;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPledge() {
        return pledge;
    }

    public void setPledge(String pledge) {
        this.pledge = pledge;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getSiblingId() {
        return siblingId;
    }

    public void setSiblingId(int siblingId) {
        this.siblingId = siblingId;
    }

    public String getSiblingName() {
        return siblingName;
    }

    public void setSiblingName(String siblingName) {
        this.siblingName = siblingName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", school='" + school + '\'' +
                ", pledge='" + pledge + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", siblingId=" + siblingId +
                ", siblingName='" + siblingName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}

