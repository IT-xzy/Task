package service;

public class Student {
    //分别定义姓名、年龄、id
    private String name;
    private Integer age;
    private Integer id;

    //定义获取name的方法
    public String getName() {
        return name;
    }
    //定义改写name的方法
    public void setName(String name) {
        this.name = name;
    }


    //定义改写id的方法
    public void setId(Integer id) {
        this.id = id;
    }

    //定义获取 id 的方法
    public Integer getId() {
        return id;
    }

    //定义改写age的方法
    public void setAge(Integer age) {
        this.age = age;
    }

    //定义获取 age 的方法
    public Integer getAge() {
        return age;
    }
}
