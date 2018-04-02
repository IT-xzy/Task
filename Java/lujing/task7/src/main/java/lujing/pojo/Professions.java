package lujing.pojo;

import java.io.Serializable;

public class Professions implements Serializable{
    private Integer id;

    private String profession;

    private String picturePath;

    private String introduce;

    private String level;

    private String difficult;

    private String growUp;

    private String scarcity;

    private String salary1;

    private String salary2;

    private String salary3;

    private String tips;

    private Integer ppid;

    private Long createAt;

    private Long updateAt;
    
    private ProfessionsInfo professionsInfo;
    
    public ProfessionsInfo getProfessionsInfo() {
        return professionsInfo;
    }
    
    public void setProfessionsInfo(ProfessionsInfo professionsInfo) {
        this.professionsInfo = professionsInfo;
    }
    
    public Professions(Integer id, String profession, String picturePath, String introduce, String level, String difficult, String growUp, String scarcity, String salary1, String salary2, String salary3, String tips, Integer ppid, Long createAt, Long updateAt) {
        this.id = id;
        this.profession = profession;
        this.picturePath = picturePath;
        this.introduce = introduce;
        this.level = level;
        this.difficult = difficult;
        this.growUp = growUp;
        this.scarcity = scarcity;
        this.salary1 = salary1;
        this.salary2 = salary2;
        this.salary3 = salary3;
        this.tips = tips;
        this.ppid = ppid;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Professions() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult == null ? null : difficult.trim();
    }

    public String getGrowUp() {
        return growUp;
    }

    public void setGrowUp(String growUp) {
        this.growUp = growUp == null ? null : growUp.trim();
    }

    public String getScarcity() {
        return scarcity;
    }

    public void setScarcity(String scarcity) {
        this.scarcity = scarcity == null ? null : scarcity.trim();
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1 == null ? null : salary1.trim();
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2 == null ? null : salary2.trim();
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3 == null ? null : salary3.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
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