/**
 * Author: 老王
 * Date: 2019/4/14 0:49
 */
package cn.wp.entity;

public class Demo {
    private int id;
    private String name;
    private int qq;
    private String school;

    public Demo() {
    }

    public Demo(int id, String name, int qq, String school) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", school='" + school + '\'' +
                "}\r\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
