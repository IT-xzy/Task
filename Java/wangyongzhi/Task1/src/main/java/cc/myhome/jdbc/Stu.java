package cc.myhome.jdbc;

public class Stu {
    private long line_id;
    private String name;
    private String qq;
    private String type;
    private String time;
    private String school;
    private String link;
    private String wish;
    private String senior;
    private String how;
    private long create;
    private long update;

    public Stu() {
    }

    public Stu(String name, String qq, String type,
               String time, String school, String link, String wish,
               String senior, String how, long create, long update) {
        //此处构造函数没有自增id。
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.time = time;
        this.school = school;
        this.link = link;
        this.wish = wish;
        this.senior = senior;
        this.how = how;
        this.create = create;
        this.update = update;
    }

    public void setLine_id(long line_id) {
        this.line_id = line_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQQ(String qq) {
        this.qq = qq;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public long getLine_id() {
        return line_id;
    }

    public String getName() {
        return name;

    }

    public String getQQ() {
        return qq;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String getSchool() {
        return school;
    }

    public String getLink() {
        return link;
    }

    public String getWish() {
        return wish;
    }

    public String getSenior() {
        return senior;
    }

    public String getHow() {
        return how;
    }

    public long getCreate() {
        return create;
    }

    public long getUpdate() {
        return update;
    }
}
