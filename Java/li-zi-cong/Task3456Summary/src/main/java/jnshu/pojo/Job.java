package jnshu.pojo;

public class Job {
    String job;
    String introduce;
    String threshold;
    String degree_of_difficulty;
    String grow_year;
    String need;
    String need_know;
    String detailed;

    public Job() {
    }

    public Job(String job, String introduce, String threshold, String degree_of_difficulty, String grow_year, String need, String need_know, String detailed) {
        this.job = job;
        this.introduce = introduce;
        this.threshold = threshold;
        this.degree_of_difficulty = degree_of_difficulty;
        this.grow_year = grow_year;
        this.need = need;
        this.need_know = need_know;
        this.detailed = detailed;
    }

    @Override
    public String toString() {
        return "Job{" +
                "job='" + job + '\'' +
                ", introduce='" + introduce + '\'' +
                ", threshold='" + threshold + '\'' +
                ", degree_of_difficulty='" + degree_of_difficulty + '\'' +
                ", grow_year='" + grow_year + '\'' +
                ", need='" + need + '\'' +
                ", need_know='" + need_know + '\'' +
                ", detailed='" + detailed + '\'' +
                '}';
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getDegree_of_difficulty() {
        return degree_of_difficulty;
    }

    public void setDegree_of_difficulty(String degree_of_difficulty) {
        this.degree_of_difficulty = degree_of_difficulty;
    }

    public String getGrow_year() {
        return grow_year;
    }

    public void setGrow_year(String grow_year) {
        this.grow_year = grow_year;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getNeed_know() {
        return need_know;
    }

    public void setNeed_know(String need_know) {
        this.need_know = need_know;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }
}
