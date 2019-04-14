package com.ptteng.entity;

public class Direction {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}