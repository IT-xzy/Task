package com.jnshu.clroom.beans;

public class Message {
    private Integer id;

    private Long paintingId;

    private String guestbookName;

    private String guestbookStatus;

    private Long createTime;

    private Long updateTime;

    private String guestbookMessage;

    public Message(Integer id, Long paintingId, String guestbookName, String guestbookStatus, Long createTime, Long updateTime, String guestbookMessage) {
        this.id = id;
        this.paintingId = paintingId;
        this.guestbookName = guestbookName;
        this.guestbookStatus = guestbookStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.guestbookMessage = guestbookMessage;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(Long paintingId) {
        this.paintingId = paintingId;
    }

    public String getGuestbookName() {
        return guestbookName;
    }

    public void setGuestbookName(String guestbookName) {
        this.guestbookName = guestbookName == null ? null : guestbookName.trim();
    }

    public String getGuestbookStatus() {
        return guestbookStatus;
    }

    public void setGuestbookStatus(String guestbookStatus) {
        this.guestbookStatus = guestbookStatus == null ? null : guestbookStatus.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getGuestbookMessage() {
        return guestbookMessage;
    }

    public void setGuestbookMessage(String guestbookMessage) {
        this.guestbookMessage = guestbookMessage == null ? null : guestbookMessage.trim();
    }
}