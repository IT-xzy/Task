package task.pojo;
//job页的工程师介绍
public class Engineer
{
    private Integer id;
    private Long createAt;
    private Long updateAt;
    private String img;
    private String type;
    private String intro;
    private String sill;
    private Integer degree;
    private Integer growth;
    private Integer scarcity;
    private Integer salaryOne;
    private Integer salaryThree;
    private Integer salaryFive;
    private Integer proceed;
    private String tip;



    @Override
    public String toString() {
        return "EngineerDao{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", img='" + img + '\'' +
                ", type='" + type + '\'' +
                ", intro='" + intro + '\'' +
                ", sill='" + sill + '\'' +
                ", degree=" + degree +
                ", growth=" + growth +
                ", scarcity=" + scarcity +
                ", salaryOne=" + salaryOne +
                ", salaryThree=" + salaryThree +
                ", salaryFive=" + salaryFive +
                ", proceed=" + proceed +
                ", tip='" + tip + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSill() {
        return sill;
    }

    public void setSill(String sill) {
        this.sill = sill;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getScarcity() {
        return scarcity;
    }

    public void setScarcity(Integer scarcity) {
        this.scarcity = scarcity;
    }

    public Integer getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(Integer salaryOne) {
        this.salaryOne = salaryOne;
    }

    public Integer getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(Integer salaryThree) {
        this.salaryThree = salaryThree;
    }

    public Integer getSalaryFive() {
        return salaryFive;
    }

    public void setSalaryFive(Integer salaryFive) {
        this.salaryFive = salaryFive;
    }

    public Integer getProceed() {
        return proceed;
    }

    public void setProceed(Integer proceed) {
        this.proceed = proceed;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
