package jnshu.model;

public class User {
//    实体类
    private long id;
    private String type;
    private String name;
    private long admissionTime;
    private String graduatedSchool;
    private String daliyLink;
    private String volunte;
    private String brother;
    private String source;
    private long createAt;
    private long updateAt;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", admissionTime=" + admissionTime +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", daliyLink='" + daliyLink + '\'' +
                ", volunte='" + volunte + '\'' +
                ", brother='" + brother + '\'' +
                ", source='" + source + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(long admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getDaliyLink() {
        return daliyLink;
    }

    public void setDaliyLink(String daliyLink) {
        this.daliyLink = daliyLink;
    }

    public String getVolunte() {
        return volunte;
    }

    public void setVolunte(String volunte) {
        this.volunte = volunte;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
