package com.jnshu.modle;

/**
 * @program: SSM_Tiles
 * @description: 学员实体类
 * @author: Mr.xweiba
 * @create: 2018-05-10 23:41
 **/

public class Student {
    private Long id;
    private String stuName;
    private String stuTitle;
    private String stuIntroduction;
    private Boolean isWork;
    private Boolean isSuper;
    private String stuProfession;
    private Long create_by;
    private Long update_by;
    private Long create_at;
    private Long update_at;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuTitle='" + stuTitle + '\'' +
                ", stuIntroduction='" + stuIntroduction + '\'' +
                ", isWork=" + isWork +
                ", isSuper=" + isSuper +
                ", stuProfession='" + stuProfession + '\'' +
                ", create_by=" + create_by +
                ", update_by=" + update_by +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuIntroduction() {
        return stuIntroduction;
    }

    public void setStuIntroduction(String stuIntroduction) {
        this.stuIntroduction = stuIntroduction;
    }

    public Boolean getIsWork() {
        return isWork;
    }

    public void setIsWork(Boolean isWork) {
        this.isWork = isWork;
    }

    public String getStuTitle() {
        return stuTitle;
    }

    public void setStuTitle(String stuTitle) {
        this.stuTitle = stuTitle;
    }


    public Boolean getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Boolean isSuper) {
        this.isSuper = isSuper;
    }

    public String getStuProfession() {
        return stuProfession;
    }

    public void setStuProfession(String stuProfession) {
        this.stuProfession = stuProfession;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }

    public Long getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Long update_by) {
        this.update_by = update_by;
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
}
