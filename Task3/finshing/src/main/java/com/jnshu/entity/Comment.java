package com.jnshu.entity;

import javax.persistence.*;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * (用户昵称或者作者昵称,新加),json文件,前端传参给后端.
     */
    private String nick;

    /**
     * 作品id
     */
    @Column(name = "art_id")
    private Long artId;

    /**
     * 作者要回复的留言id
     */
    @Column(name = "reply_id")
    private Long replyId;

    /**
     * 用户留言，0：作者留言，1：用户留言
     */
    private Boolean type;

    /**
     * 留言内容，包括emoji表情
     */
    private String content;

    /**
     * 留言分类，是否精选
     */
    private Boolean selection;

    /**
     * 留言创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 留言/回复时间
     */
    @Column(name = "create_at")
    private Long createAt;

    /**
     * 更新时间
     */
    @Column(name = "update_at")
    private Long updateAt;

    /**
     * 更改留言者
     */
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
     * 获取(用户昵称或者作者昵称,新加),json文件,前端传参给后端.
     *
     * @return nick - (用户昵称或者作者昵称,新加),json文件,前端传参给后端.
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置(用户昵称或者作者昵称,新加),json文件,前端传参给后端.
     *
     * @param nick (用户昵称或者作者昵称,新加),json文件,前端传参给后端.
     */
    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    /**
     * 获取作品id
     *
     * @return art_id - 作品id
     */
    public Long getArtId() {
        return artId;
    }

    /**
     * 设置作品id
     *
     * @param artId 作品id
     */
    public void setArtId(Long artId) {
        this.artId = artId;
    }

    /**
     * 获取作者要回复的留言id
     *
     * @return reply_id - 作者要回复的留言id
     */
    public Long getReplyId() {
        return replyId;
    }

    /**
     * 设置作者要回复的留言id
     *
     * @param replyId 作者要回复的留言id
     */
    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    /**
     * 获取用户留言，0：作者留言，1：用户留言
     *
     * @return type - 用户留言，0：作者留言，1：用户留言
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置用户留言，0：作者留言，1：用户留言
     *
     * @param type 用户留言，0：作者留言，1：用户留言
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取留言内容，包括emoji表情
     *
     * @return content - 留言内容，包括emoji表情
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置留言内容，包括emoji表情
     *
     * @param content 留言内容，包括emoji表情
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取留言分类，是否精选
     *
     * @return selection - 留言分类，是否精选
     */
    public Boolean getSelection() {
        return selection;
    }

    /**
     * 设置留言分类，是否精选
     *
     * @param selection 留言分类，是否精选
     */
    public void setSelection(Boolean selection) {
        this.selection = selection;
    }

    /**
     * 获取留言创建者
     *
     * @return create_by - 留言创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置留言创建者
     *
     * @param createBy 留言创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取留言/回复时间
     *
     * @return create_at - 留言/回复时间
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * 设置留言/回复时间
     *
     * @param createAt 留言/回复时间
     */
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    /**
     * 获取更新时间
     *
     * @return update_at - 更新时间
     */
    public Long getUpdateAt() {
        return updateAt;
    }

    /**
     * 设置更新时间
     *
     * @param updateAt 更新时间
     */
    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 获取更改留言者
     *
     * @return update_by - 更改留言者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更改留言者
     *
     * @param updateBy 更改留言者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}