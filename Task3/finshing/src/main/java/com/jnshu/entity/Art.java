package com.jnshu.entity;

import javax.persistence.*;

public class Art {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 作者
     */
    private String author;

    /**
     * 作品名称
     */
    private String name;

    /**
     * 0:下架，1：上架
     */
    private Boolean state;

    /**
     * 作品题材（作品集分类）所属二级作品集名称梦雨童乡;日常随笔等二级标题
     */
    @Column(name = "first_id")
    private Long firstId;

    /**
     * 作品类型，架上绘画/装置;影像/摄影等一级标题
     */
    @Column(name = "second_id")
    private Long secondId;

    /**
     * 作品简介，300字以内
     */
    private String introduce;

    /**
     * 缩略图,应该是所属的二级作品集的封面
     */
    @Column(name = "img_second_naill")
    private String imgSecondNaill;

    /**
     * 视频
     */
    private String video;

    /**
     * 是否输入视频链接，0图片链接；1视频链接
     */
    @Column(name = "is_link")
    private Boolean isLink;

    /**
     * 作品详情图片
     */
    @Column(name = "img_detail")
    private String imgDetail;

    /**
     * 详情，字符串，富文本编辑
     */
    @Column(name = "article_detail")
    private String articleDetail;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_at")
    private Long updateAt;

    @Column(name = "update_by")
    private String updateBy;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取作品名称
     *
     * @return name - 作品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置作品名称
     *
     * @param name 作品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取0:下架，1：上架
     *
     * @return state - 0:下架，1：上架
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置0:下架，1：上架
     *
     * @param state 0:下架，1：上架
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取作品题材（作品集分类）所属二级作品集名称梦雨童乡;日常随笔等二级标题
     *
     * @return first_id - 作品题材（作品集分类）所属二级作品集名称梦雨童乡;日常随笔等二级标题
     */
    public Long getFirstId() {
        return firstId;
    }

    /**
     * 设置作品题材（作品集分类）所属二级作品集名称梦雨童乡;日常随笔等二级标题
     *
     * @param firstId 作品题材（作品集分类）所属二级作品集名称梦雨童乡;日常随笔等二级标题
     */
    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    /**
     * 获取作品类型，架上绘画/装置;影像/摄影等一级标题
     *
     * @return second_id - 作品类型，架上绘画/装置;影像/摄影等一级标题
     */
    public Long getSecondId() {
        return secondId;
    }

    /**
     * 设置作品类型，架上绘画/装置;影像/摄影等一级标题
     *
     * @param secondId 作品类型，架上绘画/装置;影像/摄影等一级标题
     */
    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    /**
     * 获取作品简介，300字以内
     *
     * @return introduce - 作品简介，300字以内
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置作品简介，300字以内
     *
     * @param introduce 作品简介，300字以内
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 获取缩略图,应该是所属的二级作品集的封面
     *
     * @return img_second_naill - 缩略图,应该是所属的二级作品集的封面
     */
    public String getImgSecondNaill() {
        return imgSecondNaill;
    }

    /**
     * 设置缩略图,应该是所属的二级作品集的封面
     *
     * @param imgSecondNaill 缩略图,应该是所属的二级作品集的封面
     */
    public void setImgSecondNaill(String imgSecondNaill) {
        this.imgSecondNaill = imgSecondNaill == null ? null : imgSecondNaill.trim();
    }

    /**
     * 获取视频
     *
     * @return video - 视频
     */
    public String getVideo() {
        return video;
    }

    /**
     * 设置视频
     *
     * @param video 视频
     */
    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    /**
     * 获取是否输入视频链接，0图片链接；1视频链接
     *
     * @return is_link - 是否输入视频链接，0图片链接；1视频链接
     */
    public Boolean getIsLink() {
        return isLink;
    }

    /**
     * 设置是否输入视频链接，0图片链接；1视频链接
     *
     * @param isLink 是否输入视频链接，0图片链接；1视频链接
     */
    public void setIsLink(Boolean isLink) {
        this.isLink = isLink;
    }

    /**
     * 获取作品详情图片
     *
     * @return img_detail - 作品详情图片
     */
    public String getImgDetail() {
        return imgDetail;
    }

    /**
     * 设置作品详情图片
     *
     * @param imgDetail 作品详情图片
     */
    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail == null ? null : imgDetail.trim();
    }

    /**
     * 获取详情，字符串，富文本编辑
     *
     * @return article_detail - 详情，字符串，富文本编辑
     */
    public String getArticleDetail() {
        return articleDetail;
    }

    /**
     * 设置详情，字符串，富文本编辑
     *
     * @param articleDetail 详情，字符串，富文本编辑
     */
    public void setArticleDetail(String articleDetail) {
        this.articleDetail = articleDetail == null ? null : articleDetail.trim();
    }

    /**
     * @return create_at
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return update_at
     */
    public Long getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt
     */
    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}