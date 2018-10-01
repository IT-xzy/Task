package spring.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;  //学生ID
    private String name;  //学生名称
    private Integer good;  //是否为优秀学员
    private Integer offer;  //是否找到满意工作
    private String resume;  //优秀学员展示
    private Long creatdate;  //创建时间
    private Long up;   //更新时间
    private String occupation; //选择职业
    private String image;  //头像
    private String email;  //邮箱
    private String telephone;  //电话
    private String state;  //学习状态
    private Long end;  //结业时间
    private String username;  //用户账号

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", good=" + good +
                ", offer=" + offer +
                ", resume='" + resume + '\'' +
                ", creatdate=" + creatdate +
                ", up=" + up +
                ", occupation='" + occupation + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", state='" + state + '\'' +
                ", end=" + end +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Long creatdate) {
        this.creatdate = creatdate;
    }

    public Long getUp() {
        return up;
    }

    public void setUp(Long up) {
        this.up = up;
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
        this.name = name;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
