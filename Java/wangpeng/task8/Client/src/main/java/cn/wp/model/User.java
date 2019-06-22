package cn.wp.model;

import java.io.Serializable;

/** @ClassName: User @Description: 登录 @Author: 老王 @Date: 2019/5/23 12:36 @Version: 1.0 */
public class User implements Serializable {
  private static final long serialVersionUID = 6377800853427408223L;
  private Long id;
  private String name;
  private String password;
  private String phone;
  private String mail;
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", password='"
        + password
        + '\''
        + ", phone='"
        + phone
        + '\''
        + ", mail='"
        + mail
        + '\''
        + ", code='"
        + code
        + '\''
        + '}';
  }
}
