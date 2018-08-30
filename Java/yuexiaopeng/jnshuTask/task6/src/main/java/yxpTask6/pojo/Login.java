package yxpTask6.pojo;


public class Login {

  private long createAt;
  private long updateAt;
  private String loginId;
  private String loginAccount;
  private String loginPassword;
  private String loginName;
  private String loginPicture;
  private String loginSalt;

  public Login(long createAt, long updateAt, String loginId, String loginAccount, String loginPassword, String loginName, String loginPicture, String loginSalt) {
    this.createAt = createAt;
    this.updateAt = updateAt;
    this.loginId = loginId;
    this.loginAccount = loginAccount;
    this.loginPassword = loginPassword;
    this.loginName = loginName;
    this.loginPicture = loginPicture;
    this.loginSalt = loginSalt;
  }

  public Login() {

  }

  @Override
  public String toString() {
    return "Login{" +
            "createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", loginId='" + loginId + '\'' +
            ", loginAccount='" + loginAccount + '\'' +
            ", loginPassword='" + loginPassword + '\'' +
            ", loginName='" + loginName + '\'' +
            ", loginPicture='" + loginPicture + '\'' +
            ", loginSalt='" + loginSalt + '\'' +
            '}';
  }

  public String getLoginAccount() {
    return loginAccount;
  }

  public void setLoginAccount(String loginAccount) {
    this.loginAccount = loginAccount;
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


  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }


  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }


  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }


  public String getLoginPicture() {
    return loginPicture;
  }

  public void setLoginPicture(String loginPicture) {
    this.loginPicture = loginPicture;
  }


  public String getLoginSalt() {
    return loginSalt;
  }

  public void setLoginSalt(String loginSalt) {
    this.loginSalt = loginSalt;
  }

}
