package com.model;
/*
 * @ClassName:Code
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/4 11:25
 **/

public class Code {
    private long codeId;
    private long userId;
    private Long tel;
    private String telCode;
    private Long creatTime;
    private Long updateTime;
    private int telSum;

    public long getCodeId() {
        return codeId;
    }

    public Code setCodeId(long codeId) {
        this.codeId = codeId;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Code setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public Long getTel() {
        return tel;
    }

    public Code setTel(Long tel) {
        this.tel = tel;
        return this;
    }

    public String getTelCode() {
        return telCode;
    }

    public Code setTelCode(String telCode) {
        this.telCode = telCode;
        return this;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public Code setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Code setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public int getTelSum() {
        return telSum;
    }

    public Code setTelSum(int telSum) {
        this.telSum = telSum;
        return this;
    }

    @Override
    public String toString() {
        return "Code{" +
                "codeId=" + codeId +
                ", userId=" + userId +
                ", tel=" + tel +
                ", telCode='" + telCode + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", telSum=" + telSum +
                '}';
    }
}
