package hzw.model;

import java.io.Serializable;

public class Students implements Serializable {
    private Long stuId;
    private String stuName;
    private String stuIntroduction;
    private Integer stuWork;
    private Integer stuSuper;
    private String stuProfession;
    private String stuPortrait;
    private Long create_at;
    private Long update_at;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
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

    public Integer getStuWork() {
        return stuWork;
    }

    public void setStuWork(Integer stuWork) {
        this.stuWork = stuWork;
    }

    public Integer getStuSuper() {
        return stuSuper;
    }

    public void setStuSuper(Integer stuSuper) {
        this.stuSuper = stuSuper;
    }

    public String getStuProfession() {
        return stuProfession;
    }

    public void setStuProfession(String stuProfession) {
        this.stuProfession = stuProfession;
    }

    public String getStuPortrait() {
        return stuPortrait;
    }

    public void setStuPortrait(String stuPortrait) {
        this.stuPortrait = stuPortrait;
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

    @Override
    public String toString() {
        return "Students{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuIntroduction='" + stuIntroduction + '\'' +
                ", stuWork=" + stuWork +
                ", stuSuper=" + stuSuper +
                ", stuProfession='" + stuProfession + '\'' +
                ", stuPortrait='" + stuPortrait + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
