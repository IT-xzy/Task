package Task4.pojo;

import java.io.Serializable;

public class Position implements Serializable {
    private static final long serialVersionUID = 8243899936960034637L;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", classes=" + classes +
                ", salary1year=" + salary1year +
                ", salary3year='" + salary3year + '\'' +
                ", introduce='" + introduce + '\'' +
                ", need='" + need + '\'' +
                ", logo='" + logo + '\'' +
                ", grow='" + grow + '\'' +
                ", prompt='" + prompt + '\'' +
                '}';
    }

    private int id;
    private String classes;
    private String salary1year;
    private String salary3year;
    private String salary4year;
    private String logo;
    private String grow;
    private String prompt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSalary1year() {
        return salary1year;
    }

    public void setSalary1year(String salary1year) {
        this.salary1year = salary1year;
    }

    public String getSalary3year() {
        return salary3year;
    }

    public void setSalary3year(String salary3year) {
        this.salary3year = salary3year;
    }

    public String getSalary4year() {
        return salary4year;
    }

    public void setSalary4year(String salary4year) {
        this.salary4year = salary4year;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGrow() {
        return grow;
    }

    public void setGrow(String grow) {
        this.grow = grow;
    }

    private String introduce;
    private String need;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }




}
