package com.pojo;

import java.io.Serializable;

public class Paper implements Serializable{
    private static final long serialVersionUID = -3625392285765621908L;
    private int paperId;
    private String paperName;
    private int paperNum;
    private String paperDetail;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public String getPaperDetail() {
        return paperDetail;
    }

    public void setPaperDetail(String paperDetail) {
        this.paperDetail = paperDetail;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", paperNum=" + paperNum +
                ", paperDetail='" + paperDetail + '\'' +
                '}';
    }
}