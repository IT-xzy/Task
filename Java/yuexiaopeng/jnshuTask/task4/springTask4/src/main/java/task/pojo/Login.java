package task.pojo;
//home页的账户登录
public class Login
{
    private Integer id;
    private Long createAt;
    private Long updateAt;
    private Integer loginId;
    private String loginPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", loginId=" + loginId +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}
