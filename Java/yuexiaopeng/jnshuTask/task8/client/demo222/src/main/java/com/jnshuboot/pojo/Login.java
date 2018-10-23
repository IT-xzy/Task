package com.jnshuboot.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author
 */
@Component
public class Login implements Serializable {
    private Long createAt;

    private Long updateAt;

    private Long loginId;

    private String loginAccount;

    private String loginPassword;

    private String loginName;

    private String loginPicture;

    private String loginSalt;

    private String loginMobile;

    private String loginMail;

    private static final long serialVersionUID = 1L;

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

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
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

    public String getLoginMobile() {
        return loginMobile;
    }

    public void setLoginMobile(String loginMobile) {
        this.loginMobile = loginMobile;
    }

    public String getLoginMail() {
        return loginMail;
    }

    public void setLoginMail(String loginMail) {
        this.loginMail = loginMail;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Login other = (Login) that;
        return (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
                && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
                && (this.getLoginId() == null ? other.getLoginId() == null : this.getLoginId().equals(other.getLoginId()))
                && (this.getLoginAccount() == null ? other.getLoginAccount() == null : this.getLoginAccount().equals(other.getLoginAccount()))
                && (this.getLoginPassword() == null ? other.getLoginPassword() == null : this.getLoginPassword().equals(other.getLoginPassword()))
                && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
                && (this.getLoginPicture() == null ? other.getLoginPicture() == null : this.getLoginPicture().equals(other.getLoginPicture()))
                && (this.getLoginSalt() == null ? other.getLoginSalt() == null : this.getLoginSalt().equals(other.getLoginSalt()))
                && (this.getLoginMobile() == null ? other.getLoginMobile() == null : this.getLoginMobile().equals(other.getLoginMobile()))
                && (this.getLoginMail() == null ? other.getLoginMail() == null : this.getLoginMail().equals(other.getLoginMail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getLoginId() == null) ? 0 : getLoginId().hashCode());
        result = prime * result + ((getLoginAccount() == null) ? 0 : getLoginAccount().hashCode());
        result = prime * result + ((getLoginPassword() == null) ? 0 : getLoginPassword().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getLoginPicture() == null) ? 0 : getLoginPicture().hashCode());
        result = prime * result + ((getLoginSalt() == null) ? 0 : getLoginSalt().hashCode());
        result = prime * result + ((getLoginMobile() == null) ? 0 : getLoginMobile().hashCode());
        result = prime * result + ((getLoginMail() == null) ? 0 : getLoginMail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", loginId=").append(loginId);
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPicture=").append(loginPicture);
        sb.append(", loginSalt=").append(loginSalt);
        sb.append(", loginMobile=").append(loginMobile);
        sb.append(", loginMail=").append(loginMail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}