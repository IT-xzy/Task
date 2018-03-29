package jnshu.tasksix.model;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-10-13.
 */

@Component("student")
public class Student {

    private static final long serialVersionUID = -5809782578272943999L;

    Integer id;
    String user;
    String pass;
    String images;
    String profession;
    Integer classId;
    String name;
    String wish;
    Integer qq;
    Integer status;
    Long enrolAt;
    Long createAt;
    Long updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getEnrolAt() {
        return enrolAt;
    }

    public void setEnrolAt(Long enrolAt) {
        this.enrolAt = enrolAt;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }


    @Override
    public String toString(){
        return  "Student [Id = " + id + ", user = " + user + ", pass = " + pass + ", images:"  + images +
                ", profession = " + profession + ", classId = " + classId + ", name = " + name +
                "\n\t\t wish = "+ wish + ", qq = " + qq + ", status = "+ status +
                ", enrolAt = "+ enrolAt + ", createAt = " + createAt + ", updateAt = " + updateAt + "]\n";
    }


}
