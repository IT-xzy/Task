package com.artist.pojo;
import java.util.List;


/**
 *艺术家作品实例
 */
public class Production  {
    private Integer productionId;
    private String headline;
    private String introduce;
    private String authorName;
    private String category;
    private String theme;
    private String state;
    private String content;
    private Long createTime;
    private Long updateTime;

    private List<ImageAndVideo> imageAndVideos;
    private List<Message> messages;


    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ImageAndVideo> getImageAndVideos() {
        return imageAndVideos;
    }

    public void setImageAndVideos(List<ImageAndVideo> imageAndVideos) {
        this.imageAndVideos = imageAndVideos;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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

    @Override
    public String toString() {
        return "Production{" +
                "productionId=" + productionId +
                ", headline='" + headline + '\'' +
                ", introduce='" + introduce + '\'' +
                ", authorName='" + authorName + '\'' +
                ", category='" + category + '\'' +
                ", theme='" + theme + '\'' +
                ", state='" + state + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", imageAndVideos=" + imageAndVideos +
                ", messages=" + messages +
                '}';
    }
}
