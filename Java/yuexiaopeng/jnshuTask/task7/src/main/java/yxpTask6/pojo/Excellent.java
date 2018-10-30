package yxpTask6.pojo;


public class Excellent {

  private long createAt;
  private long updateAt;
  private long excellentId;
  private String excellentImg;
  private String excellentName;
  private String excellentCompany;
  private String excellentIntro;

  @Override
  public String toString() {
    return "ExcellentDao{" +
            "createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", excellentId=" + excellentId +
            ", excellentImg='" + excellentImg + '\'' +
            ", excellentName='" + excellentName + '\'' +
            ", excellentCompany='" + excellentCompany + '\'' +
            ", excellentIntro='" + excellentIntro + '\'' +
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


  public long getExcellentId() {
    return excellentId;
  }

  public void setExcellentId(long excellentId) {
    this.excellentId = excellentId;
  }


  public String getExcellentImg() {
    return excellentImg;
  }

  public void setExcellentImg(String excellentImg) {
    this.excellentImg = excellentImg;
  }


  public String getExcellentName() {
    return excellentName;
  }

  public void setExcellentName(String excellentName) {
    this.excellentName = excellentName;
  }


  public String getExcellentCompany() {
    return excellentCompany;
  }

  public void setExcellentCompany(String excellentCompany) {
    this.excellentCompany = excellentCompany;
  }


  public String getExcellentIntro() {
    return excellentIntro;
  }

  public void setExcellentIntro(String excellentIntro) {
    this.excellentIntro = excellentIntro;
  }

}
