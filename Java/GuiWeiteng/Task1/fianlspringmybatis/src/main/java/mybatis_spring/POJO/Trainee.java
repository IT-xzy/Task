package mybatis_spring.POJO;

public class Trainee {
    private int t_id;
    private int t_age;
    private String t_name;
    private String sex;
    private String t_No;
    private String registerLink;
    private Long create_time;
    private Long update_time;
    /*表格全字段构造函数*/
    public Trainee(int t_id,Long create_time,Long update_time,int t_age, String t_name, String sex, String t_No, String registerLink) {
        this.t_id=t_id;
        this.create_time=create_time;
        this.update_time=update_time;
        this.t_age = t_age;
        this.t_name = t_name;
        this.sex = sex;
        this.t_No = t_No;
        this.registerLink = registerLink;
    }
    /*不带自增字段的构造函数*/
    public Trainee(Long create_time,Long update_time,int t_age, String t_name, String sex, String t_No, String registerLink) {
        this.create_time=create_time;
        this.update_time=update_time;
        this.t_age = t_age;
        this.t_name = t_name;
        this.sex = sex;
        this.t_No = t_No;
        this.registerLink = registerLink;
    }
    /*不带自增和创建时间字段构造函数*/
    public Trainee(Long update_time,int t_age, String t_name, String sex, String t_No, String registerLink) {
        this.update_time=update_time;
        this.t_age = t_age;
        this.t_name = t_name;
        this.sex = sex;
        this.t_No = t_No;
        this.registerLink = registerLink;
    }
    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public int getT_age() {
        return t_age;
    }

    public void setT_age(int t_age) {
        this.t_age = t_age;
    }

    public String getT_name() {
        return t_name;
    }

    public String getT_No() {
        return t_No;
    }

    public void setT_No(String t_No) {
        this.t_No = t_No;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegisterLink() {
        return registerLink;
    }

    public void setRegisterLink(String registerLink) {
        this.registerLink = registerLink;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + t_id +
                ", age=" + t_age +
                ", name='" + t_name + '\'' +
                ", sex='" + sex + '\'' +
                ", No='" + t_No + '\'' +
                ", registerLink='" + registerLink + '\'' +
                '}';
    }
}

