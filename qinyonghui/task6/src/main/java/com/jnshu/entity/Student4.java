package com.jnshu.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class Student4 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学员姓名
     */
    private String name;

    @Column(name = "profession_id")
    private Long professionId;

    /**
     * 状态。0：在学,1:结业
     */
    private Boolean state;

    /**
     * 头像图片url
     */
    private String img;

    /**
     * 职位1:创业CEO,2:技术顾问，3：高级工程师，4：技术主管，5：技术总监
     */
    private String position;

    /**
     * 薪水
     */
    private String salary;

    /**
     * 毕业时间
     */
    @Column(name = "graduate_at")
    private Long graduateAt;

    /**
     * 个人履历
     */
    private String resume;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_at")
    private Long createAt;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
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
     * 获取学员姓名
     *
     * @return name - 学员姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学员姓名
     *
     * @param name 学员姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return profession_id
     */
    public Long getProfessionId() {
        return professionId;
    }

    /**
     * @param professionId
     */
    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    /**
     * 获取状态。0：在学,1:结业
     *
     * @return state - 状态。0：在学,1:结业
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置状态。0：在学,1:结业
     *
     * @param state 状态。0：在学,1:结业
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取头像图片url
     *
     * @return img - 头像图片url
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置头像图片url
     *
     * @param img 头像图片url
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取职位1:创业CEO,2:技术顾问，3：高级工程师，4：技术主管，5：技术总监
     *
     * @return position - 职位1:创业CEO,2:技术顾问，3：高级工程师，4：技术主管，5：技术总监
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位1:创业CEO,2:技术顾问，3：高级工程师，4：技术主管，5：技术总监
     *
     * @param position 职位1:创业CEO,2:技术顾问，3：高级工程师，4：技术主管，5：技术总监
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取薪水
     *
     * @return salary - 薪水
     */
    public String getSalary() {
        return salary;
    }

    /**
     * 设置薪水
     *
     * @param salary 薪水
     */
    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    /**
     * 获取毕业时间
     *
     * @return graduate_at - 毕业时间
     */
    public Long getGraduateAt() {
        return graduateAt;
    }

    /**
     * 设置毕业时间
     *
     * @param graduateAt 毕业时间
     */
    public void setGraduateAt(Long graduateAt) {
        this.graduateAt = graduateAt;
    }

    /**
     * 获取个人履历
     *
     * @return resume - 个人履历
     */
    public String getResume() {
        return resume;
    }

    /**
     * 设置个人履历
     *
     * @param resume 个人履历
     */
    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_at - 创建时间
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * 设置创建时间
     *
     * @param createAt 创建时间
     */
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
    public  Student4(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student4 student4 = (Student4) o;
        return Objects.equals(id, student4.id) && Objects.equals(name, student4.name)
                && Objects.equals(professionId, student4.professionId)
                && Objects.equals(state, student4.state)
                && Objects.equals(img, student4.img)
                && Objects.equals(position, student4.position)
                && Objects.equals(salary, student4.salary)
                && Objects.equals(graduateAt, student4.graduateAt)
                && Objects.equals(resume, student4.resume)
                && Objects.equals(createBy, student4.createBy)
                && Objects.equals(createAt, student4.createAt)
                && Objects.equals(updateBy, student4.updateBy)
                && Objects.equals(updateAt, student4.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, professionId, state, img, position, salary,
                graduateAt, resume, createBy, createAt, updateBy, updateAt);
    }

    @Override
    public String toString() {
        return "Student4{" + "id=" + id + ", name='" + name + '\'' + ", professionId=" + professionId + ", state=" + state + ", img='" + img + '\'' + ", position='" + position + '\'' + ", salary='" + salary + '\'' + ", graduateAt=" + graduateAt + ", resume='" + resume + '\'' + ", createBy='" + createBy + '\'' + ", createAt=" + createAt + ", updateBy='" + updateBy + '\'' + ", updateAt=" + updateAt + '}';
    }
}