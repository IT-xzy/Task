package yxpTask6.pojo;


public class Engineer {

  private long createAt;
  private long updateAt;
  private long engineerId;
  private String engineerImg;
  private String engineerType;
  private String engineerIntro;
  private String engineerSill;
  private String engineerDegree;
  private String engineerGrowth;
  private String engineerScarcity;
  private long engineerSalaryOne;
  private long engineerSalaryThree;
  private long engineerSalaryFive;
  private long engineerProceed;
  private String engineerTip;

  @Override
  public String toString() {
    return "EngineerDao{" +
            "createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", engineerId=" + engineerId +
            ", engineerImg='" + engineerImg + '\'' +
            ", engineerType='" + engineerType + '\'' +
            ", engineerIntro='" + engineerIntro + '\'' +
            ", engineerSill='" + engineerSill + '\'' +
            ", engineerDegree='" + engineerDegree + '\'' +
            ", engineerGrowth='" + engineerGrowth + '\'' +
            ", engineerScarcity='" + engineerScarcity + '\'' +
            ", engineerSalaryOne=" + engineerSalaryOne +
            ", engineerSalaryThree=" + engineerSalaryThree +
            ", engineerSalaryFive=" + engineerSalaryFive +
            ", engineerProceed=" + engineerProceed +
            ", engineerTip='" + engineerTip + '\'' +
            '}';
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


  public long getEngineerId() {
    return engineerId;
  }

  public void setEngineerId(long engineerId) {
    this.engineerId = engineerId;
  }


  public String getEngineerImg() {
    return engineerImg;
  }

  public void setEngineerImg(String engineerImg) {
    this.engineerImg = engineerImg;
  }


  public String getEngineerType() {
    return engineerType;
  }

  public void setEngineerType(String engineerType) {
    this.engineerType = engineerType;
  }


  public String getEngineerIntro() {
    return engineerIntro;
  }

  public void setEngineerIntro(String engineerIntro) {
    this.engineerIntro = engineerIntro;
  }


  public String getEngineerSill() {
    return engineerSill;
  }

  public void setEngineerSill(String engineerSill) {
    this.engineerSill = engineerSill;
  }


  public String getEngineerDegree() {
    return engineerDegree;
  }

  public void setEngineerDegree(String engineerDegree) {
    this.engineerDegree = engineerDegree;
  }


  public String getEngineerGrowth() {
    return engineerGrowth;
  }

  public void setEngineerGrowth(String engineerGrowth) {
    this.engineerGrowth = engineerGrowth;
  }


  public String getEngineerScarcity() {
    return engineerScarcity;
  }

  public void setEngineerScarcity(String engineerScarcity) {
    this.engineerScarcity = engineerScarcity;
  }


  public long getEngineerSalaryOne() {
    return engineerSalaryOne;
  }

  public void setEngineerSalaryOne(long engineerSalaryOne) {
    this.engineerSalaryOne = engineerSalaryOne;
  }


  public long getEngineerSalaryThree() {
    return engineerSalaryThree;
  }

  public void setEngineerSalaryThree(long engineerSalaryThree) {
    this.engineerSalaryThree = engineerSalaryThree;
  }


  public long getEngineerSalaryFive() {
    return engineerSalaryFive;
  }

  public void setEngineerSalaryFive(long engineerSalaryFive) {
    this.engineerSalaryFive = engineerSalaryFive;
  }


  public long getEngineerProceed() {
    return engineerProceed;
  }

  public void setEngineerProceed(long engineerProceed) {
    this.engineerProceed = engineerProceed;
  }


  public String getEngineerTip() {
    return engineerTip;
  }

  public void setEngineerTip(String engineerTip) {
    this.engineerTip = engineerTip;
  }

}
