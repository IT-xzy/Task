package com.ptt.pojo;

import com.ptt.dao.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1114L;

    private Long id;

    @NotBlank(message = "{student.name.length.blank}", groups = {GroupLogin.class, GroupRegister.class})
    @Size(min = 6, max = 20, message = "{student.name.length.error}", groups = {GroupLogin.class, GroupRegister.class})
    private String name;

    @NotBlank(message = "{student.password.length.blank}", groups = {GroupLogin.class, GroupRegister.class})
    @Size(min = 6, max = 20, message = "{student.password.length.error}", groups = {GroupLogin.class, GroupRegister.class})
    private String password;

    @NotNull(message = "{student.tel.length.blank}", groups = GroupTelephone.class)
    @Range(min = 13000000000L, max = 19000000000L, message = "{student.tel.length.error}", groups = GroupTelephone.class)
    private Long tel;

    @Email(message = "{student.email.type.error}", groups = GroupEmail.class)
    @NotBlank(message = "{student.email.length.blank}", groups = GroupEmail.class)
    private String email;

    @NotBlank(message = "{student.profilePhoto.length.blank}", groups = GroupPhoto.class)
    private String profilePhoto;

    private String sex;

    @NotNull(message = "{student.qq.length.blank}", groups = GroupRegister.class)
    @Range(min = 99999L, max = 1000000000000L, message = "{student.QQ.length.error}", groups = GroupRegister.class)
    private Long qq;

    @NotBlank(message = "{student.whatType.length.blank}", groups = GroupRegister.class)
    private String whatType;

    @NotNull(message = "{student.name.joinTime.blank}", groups = GroupRegister.class)
    private Long joinTime;

    private String school;

    @NotBlank(message = "{student.studentId.length.blank}", groups = GroupRegister.class)
    private String studentId;

    @NotBlank(message = "{student.link.length.blank}", groups = GroupRegister.class)
    @URL(message = "{student.link.type.error}", groups = {GroupRegister.class})
    private String link;

    @NotBlank(message = "{student.wishes.length.blank}", groups = GroupRegister.class)
    private String wishes;

    private String tutorBro;

    private String knowFrom;

    private Long createAt;

    private Long updateAt;

    public Student(Long id, String name, String password, Long tel, String email, String profilePhoto, String sex,
                   Long qq, String whatType, Long joinTime, String school, String studentId, String link, String wishes,
                   String tutorBro, String knowFrom, Long createAt, Long updateAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.profilePhoto = profilePhoto;
        this.sex = sex;
        this.qq = qq;
        this.whatType = whatType;
        this.joinTime = joinTime;
        this.school = school;
        this.studentId = studentId;
        this.link = link;
        this.wishes = wishes;
        this.tutorBro = tutorBro;
        this.knowFrom = knowFrom;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Student() {
        super();
    }

    @Override
    public String toString(){
        return "id：" + id + "name：" + name + "password：" + password + "tel：" + tel + "email：" + email
                + "profilePhoto：" + profilePhoto + "sex：" + sex + "qq：" + qq + "whatType：" + whatType
                + "joinTime：" + joinTime + "school：" + school + "studentId：" + studentId + "link：" + link
                + "wishes：" + wishes + "tutorBro：" + tutorBro + "knowFrom：" + knowFrom + "createAt：" + createAt
                + "updateAt：" + updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto == null ? null : profilePhoto.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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
        this.whatType = whatType == null ? null : whatType.trim();
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
        this.school = school == null ? null : school.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes == null ? null : wishes.trim();
    }

    public String getTutorBro() {
        return tutorBro;
    }

    public void setTutorBro(String tutorBro) {
        this.tutorBro = tutorBro == null ? null : tutorBro.trim();
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom == null ? null : knowFrom.trim();
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
}