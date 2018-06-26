package pojo;

public class Job {
    private Integer id;
    private String jobName;
    private String  introduction;
    private Integer rarity;
    private Integer conpanyNumber;
    private Integer difficulty;
    private Integer threshold;
    private String  salary_min;
    private String  salary_max;
    private Integer count;
    private String tip;
    private long creat_at;
    private long uodate_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Integer getConpanyNumber() {
        return conpanyNumber;
    }

    public void setConpanyNumber(Integer conpanyNumber) {
        this.conpanyNumber = conpanyNumber;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(String salary_min) {
        this.salary_min = salary_min;
    }

    public String getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(String salary_max) {
        this.salary_max = salary_max;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public long getCreat_at() {
        return creat_at;
    }

    public void setCreat_at(long creat_at) {
        this.creat_at = creat_at;
    }

    public long getUodate_at() {
        return uodate_at;
    }

    public void setUodate_at(long uodate_at) {
        this.uodate_at = uodate_at;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", rarity=" + rarity +
                ", conpanyNumber=" + conpanyNumber +
                ", difficulty=" + difficulty +
                ", threshold=" + threshold +
                ", salary_min='" + salary_min + '\'' +
                ", salary_max='" + salary_max + '\'' +
                ", count=" + count +
                ", tip='" + tip + '\'' +
                ", creat_at=" + creat_at +
                ", uodate_at=" + uodate_at +
                '}';
    }
}
