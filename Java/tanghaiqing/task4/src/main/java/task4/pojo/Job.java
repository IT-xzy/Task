package task4.pojo;

public class Job {
    private Integer jobId;
    private String jobName;
    private String jobCategory;
    private String jobIntro;
    private String jobImage;
    private Integer threshold;
    private String cycle;
    private Integer scarcity;
    private String term1;
    private String term2;
    private String term3;
    private String salary1;
    private String salary2;
    private String salary3;
    private Integer atSchool;
    private String hint;
    private String jobIntroduce;
    private Long updateTime;

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobIntro() {
        return jobIntro;
    }

    public void setJobIntro(String jobIntro) {
        this.jobIntro = jobIntro;
    }

    public String getJobImage() {
        return jobImage;
    }

    public void setJobImage(String jobImage) {
        this.jobImage = jobImage;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getScarcity() {
        return scarcity;
    }

    public void setScarcity(Integer scarcity) {
        this.scarcity = scarcity;
    }

    public String getTerm1() {
        return term1;
    }

    public void setTerm1(String term1) {
        this.term1 = term1;
    }

    public String getTerm2() {
        return term2;
    }

    public void setTerm2(String term2) {
        this.term2 = term2;
    }

    public String getTerm3() {
        return term3;
    }

    public void setTerm3(String term3) {
        this.term3 = term3;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2;
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3;
    }

    public Integer getAtSchool() {
        return atSchool;
    }

    public void setAtSchool(Integer atSchool) {
        this.atSchool = atSchool;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getJobIntroduce() {
        return jobIntroduce;
    }

    public void setJobIntroduce(String jobIntroduce) {
        this.jobIntroduce = jobIntroduce;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobCategory='" + jobCategory + '\'' +
                ", jobIntro='" + jobIntro + '\'' +
                ", jobImage='" + jobImage + '\'' +
                ", threshold=" + threshold +
                ", cycle='" + cycle + '\'' +
                ", scarcity=" + scarcity +
                ", term1='" + term1 + '\'' +
                ", term2='" + term2 + '\'' +
                ", term3='" + term3 + '\'' +
                ", salary1='" + salary1 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", atSchool=" + atSchool +
                ", hint='" + hint + '\'' +
                ", jobIntroduce='" + jobIntroduce + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
