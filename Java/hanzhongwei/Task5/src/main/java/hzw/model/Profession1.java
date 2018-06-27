package hzw.model;

/**
 *职业:
 */
public class Profession1 {
    private Long proId;
    private String proName;
    private String proIntroduction;
    private String proCompany;
    private byte proDifficulty;
    private byte proThreshold;
    private Integer proSalary_min;
    private Integer proSalary_max;
    private Long create_at;
    private Long update_at;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    public String getProCompany() {
        return proCompany;
    }

    public void setProCompany(String proCompany) {
        this.proCompany = proCompany;
    }

    public byte getProDifficulty() {
        return proDifficulty;
    }

    public void setProDifficulty(byte proDifficulty) {
        this.proDifficulty = proDifficulty;
    }

    public byte getProThreshold() {
        return proThreshold;
    }

    public void setProThreshold(byte proThreshold) {
        this.proThreshold = proThreshold;
    }

    public Integer getProSalary_min() {
        return proSalary_min;
    }

    public void setProSalary_min(Integer proSalary_min) {
        this.proSalary_min = proSalary_min;
    }

    public Integer getProSalary_max() {
        return proSalary_max;
    }

    public void setProSalary_max(Integer proSalary_max) {
        this.proSalary_max = proSalary_max;
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
        return "Profession{" +
                "id=" + proId +
                ", proName='" + proName + '\'' +
                ", proIntroduction='" + proIntroduction + '\'' +
                ", proCompany='" + proCompany + '\'' +
                ", proDifficulty=" + proDifficulty +
                ", proThreshold=" + proThreshold +
                ", proSalary_min=" + proSalary_min +
                ", proSalary_max=" + proSalary_max +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
