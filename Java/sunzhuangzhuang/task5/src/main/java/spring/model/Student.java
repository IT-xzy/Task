package spring.model;

public class Student {
    private Integer id;  //学生ID
    private String name;  //学生名称
    private Integer good;  //是否为优秀学员
    private Integer offer;  //是否找到满意工作
    private String resume;  //优秀学员展示
    private Long creatdate;
    private Long up;
    private String a; //选择职业

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
                ", a='" + a + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
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
