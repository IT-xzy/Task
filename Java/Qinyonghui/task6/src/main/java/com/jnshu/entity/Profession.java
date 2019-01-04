package com.jnshu.entity;

import javax.persistence.*;

public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学员id通过学员id查询其所学专业
     */
    @Column(name = "student_id")
    private Long studentId;

    /**
     * 图片链接
     */
    private String img;

    /**
     * 稀缺程度
     */
    @Column(name = "need_degree")
    private Integer needDegree;

    private String introduce;

    /**
     * 学习方向0：前端开发方向1:后端反向2：运维方向
     */
    private Byte direction;

    /**
     * 职业名称
     */
    private String job;

    /**
     * 入学门槛0：一星，2星，最多5星
     */
    private Byte door;

    /**
     * 0：1星,1:二星
     */
    private Byte difficulty;

    /**
     * 成长周期
     */
    private String growth;

    /**
     * 工作年限
     */
    private Integer years;

    /**
     * 薪水
     */
    private Integer salary;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_at")
    private Long updateAt;

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
     * 获取学员id通过学员id查询其所学专业
     *
     * @return student_id - 学员id通过学员id查询其所学专业
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * 设置学员id通过学员id查询其所学专业
     *
     * @param studentId 学员id通过学员id查询其所学专业
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取图片链接
     *
     * @return img - 图片链接
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片链接
     *
     * @param img 图片链接
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取稀缺程度
     *
     * @return need_degree - 稀缺程度
     */
    public Integer getNeedDegree() {
        return needDegree;
    }

    /**
     * 设置稀缺程度
     *
     * @param needDegree 稀缺程度
     */
    public void setNeedDegree(Integer needDegree) {
        this.needDegree = needDegree;
    }

    /**
     * @return introduce
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * @param introduce
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 获取学习方向0：前端开发方向1:后端反向2：运维方向
     *
     * @return direction - 学习方向0：前端开发方向1:后端反向2：运维方向
     */
    public Byte getDirection() {
        return direction;
    }

    /**
     * 设置学习方向0：前端开发方向1:后端反向2：运维方向
     *
     * @param direction 学习方向0：前端开发方向1:后端反向2：运维方向
     */
    public void setDirection(Byte direction) {
        this.direction = direction;
    }

    /**
     * 获取职业名称
     *
     * @return job - 职业名称
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置职业名称
     *
     * @param job 职业名称
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * 获取入学门槛0：一星，2星，最多5星
     *
     * @return door - 入学门槛0：一星，2星，最多5星
     */
    public Byte getDoor() {
        return door;
    }

    /**
     * 设置入学门槛0：一星，2星，最多5星
     *
     * @param door 入学门槛0：一星，2星，最多5星
     */
    public void setDoor(Byte door) {
        this.door = door;
    }

    /**
     * 获取0：1星,1:二星
     *
     * @return difficulty - 0：1星,1:二星
     */
    public Byte getDifficulty() {
        return difficulty;
    }

    /**
     * 设置0：1星,1:二星
     *
     * @param difficulty 0：1星,1:二星
     */
    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * 获取成长周期
     *
     * @return growth - 成长周期
     */
    public String getGrowth() {
        return growth;
    }

    /**
     * 设置成长周期
     *
     * @param growth 成长周期
     */
    public void setGrowth(String growth) {
        this.growth = growth == null ? null : growth.trim();
    }

    /**
     * 获取工作年限
     *
     * @return years - 工作年限
     */
    public Integer getYears() {
        return years;
    }

    /**
     * 设置工作年限
     *
     * @param years 工作年限
     */
    public void setYears(Integer years) {
        this.years = years;
    }

    /**
     * 获取薪水
     *
     * @return salary - 薪水
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置薪水
     *
     * @param salary 薪水
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
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
}