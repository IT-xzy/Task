package lujing.pojo;

public class GoodStudent {
    private Integer id;

    private String name;

    private String profession;

    private String introduce;

    private Integer studyStatus;

    public GoodStudent(Integer id, String name, String profession, String introduce, Integer studyStatus) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.introduce = introduce;
        this.studyStatus = studyStatus;
    }

    public GoodStudent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(Integer studyStatus) {
        this.studyStatus = studyStatus;
    }
    
    @Override
    public String toString() {
        return "GoodStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", introduce='" + introduce + '\'' +
                ", studyStatus=" + studyStatus +
                '}';
    }
}