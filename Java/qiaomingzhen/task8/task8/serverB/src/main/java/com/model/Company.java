package com.model;/*
 * @ClassName:Company
 * @Description:合作企业类
 * @Author qiao
 * @Date 2018/7/27 13:48
 **/

import java.io.Serializable;

public class Company implements Serializable {
    private long companyId;
    private String companyName;
    private String companyIntro;
    private String companyInfo;
    private long creatTime;
    private long updateTime;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyIntro='" + companyIntro + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
