package com.art.pojo;

public class Work {
    private Integer id;

    private String name;

    private Integer firstId;

    private Integer secondId;

    private Boolean status;

    private String introduce;

    private String thumbnail;

    private String url;

    private String content;

    private Long createAt;

    private Long updateAt;

    private String updateBy;

    public Work(Integer id, String name, Integer firstId, Integer secondId, Boolean status, String introduce, String thumbnail, String url, String content, Long createAt, Long updateAt, String updateBy) {
        this.id = id;
        this.name = name;
        this.firstId = firstId;
        this.secondId = secondId;
        this.status = status;
        this.introduce = introduce;
        this.thumbnail = thumbnail;
        this.url = url;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public Work() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Work{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", firstId=").append(firstId);
        sb.append(", secondId=").append(secondId);
        sb.append(", status=").append(status);
        sb.append(", introduce='").append(introduce).append('\'');
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy='").append(updateBy).append('\'');
        sb.append('}');
        return sb.toString();
    }
}