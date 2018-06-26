package com.student.DAO;

public class Student{
    private long id;
    private String name;
    private long create_at;
    private long update_at;

    @Override
    public String toString() {
        return "Student{" +
                "id="+ id +
                ",\t name='" + name + '\'' +
                ",\t create_at=" + create_at +
                ",\t update_at=" + update_at +
                '}'+'\n';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }
}
