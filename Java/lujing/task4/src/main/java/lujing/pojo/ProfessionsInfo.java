package lujing.pojo;

public class ProfessionsInfo {
    private Integer id;

    private String profession;

    private String info;

    public ProfessionsInfo(Integer id, String profession, String info) {
        this.id = id;
        this.profession = profession;
        this.info = info;
    }

    public ProfessionsInfo() {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}