package pojo;

public class Student {
    private Integer id;
    private String  name;
    private String introduction;
    private boolean isSuper;
    private boolean isWork;
    private int jobTitle;
    private String type;
    private long creat_at;
    private long update;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public int getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(int jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCreat_at() {
        return creat_at;
    }

    public void setCreat_at(long creat_at) {
        this.creat_at = creat_at;
    }

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", isSuper=" + isSuper +
                ", isWork=" + isWork +
                ", jobTitle=" + jobTitle +
                ", type='" + type + '\'' +
                ", creat_at=" + creat_at +
                ", update=" + update +
                '}';
    }
}

