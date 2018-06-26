package pojo;

public class job {
  private int id;
  private String name;
  private int period;
  private String type;
  private String salary1;
  private String salary2;
  private String salary3;
  private Long need;
  private String introduction;

  public String getIntroduction(){
      return introduction;
  }
  public void setIntroduction(String introduction){
      this.introduction=introduction;
  }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getNeed() {
        return need;
    }

    public void setNeed(Long need) {
        this.need = need;
    }
}
