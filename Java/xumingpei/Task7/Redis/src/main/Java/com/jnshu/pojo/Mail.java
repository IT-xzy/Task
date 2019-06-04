package com.jnshu.pojo;

/**
 * @author pipiretrak
 * @date 2019/5/24 - 12:03
 */
public class Mail {
    private int id;
    private String mailAddress;
    private String code;
    private long createAt;

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", mailAddress='" + mailAddress + '\'' +
                ", code='" + code + '\'' +
                ", createAt=" + createAt +
                '}';
    }

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

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }
}
