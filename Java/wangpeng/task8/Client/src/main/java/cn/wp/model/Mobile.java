package cn.wp.model;

import java.io.Serializable;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/12 14:11 @Version: 1.0 */
public class Mobile implements Serializable {
  private static final long serialVersionUID = 2876171691255763255L;
  private int id;
  private Long phone;
  private Long code;
  private Long creatAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Long getPhone() {
    return phone;
  }

  public void setPhone(Long phone) {
    this.phone = phone;
  }

  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public Long getCreatAt() {
    return creatAt;
  }

  public void setCreatAt(Long creatAt) {
    this.creatAt = creatAt;
  }

  @Override
  public String toString() {
    return "Mobile{"
        + "id="
        + id
        + ", phone="
        + phone
        + ", code="
        + code
        + ", creatAt="
        + creatAt
        + '}';
  }
}
