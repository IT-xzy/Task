package model;

public class Student {
    private Long id;
    private String name;
    private String qq;
    private String wish;
    private Long create_at;

    public Student(){}
    public Student(Long id,String wish)
    {
        this.id=id;
        this.wish=wish;
    }
    public Student(Long id, String name, String qq, String wish, Long create_at)
    {
        this.id=id;
        this.name=name;
        this.qq=qq;
        this.wish=wish;
        this.create_at=create_at;

    }



    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }


    public  String toString() {
        return "id="+id+" name="+name+" qq"+qq+" wish"+wish+" creat_at"+create_at;
    }
}