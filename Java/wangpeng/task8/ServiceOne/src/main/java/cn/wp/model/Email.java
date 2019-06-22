package cn.wp.model;

import java.io.Serializable;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/12 14:11 @Version: 1.0 */
public class Email implements Serializable {
  private static final long serialVersionUID = 8999868523720762341L;
  private int id;
  private String mailAddress;
  private String code;
  private Long createAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMailAddress() {
    return mailAddress;
  }

  public void setMailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Long createAt) {
    this.createAt = createAt;
  }

  @Override
  public String toString() {
    return "Email{"
        + "id="
        + id
        + ", mailAddress='"
        + mailAddress
        + '\''
        + ", code="
        + code
        + ", createAt="
        + createAt
        + '}';
  }
}
