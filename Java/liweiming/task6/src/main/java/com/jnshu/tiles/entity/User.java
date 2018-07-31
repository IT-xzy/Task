package com.jnshu.tiles.entity;


import java.io.Serializable;

public class User implements Serializable {

        private Integer id;
        private Long create_at;
        private Long update_at;

        private String qq;

//    Pattern表示自定义注解，regexp属性是正则表达式

        private String name;

        private String learning_type;
        private Long entrance_time;

        private String school;

        private Integer online_id;

        private String daily_link;

        private String wish;

        private String tutor;


        @Override
        public String toString() {
            return "UserDTO{" +
                    "id=" + id +
                    ", create_at=" + create_at +
                    ", update_at=" + update_at +
                    ", qq='" + qq + '\'' +
                    ", name='" + name + '\'' +
                    ", learning_type='" + learning_type + '\'' +
                    ", entrance_time=" + entrance_time +
                    ", school='" + school + '\'' +
                    ", online_id=" + online_id +
                    ", daily_link='" + daily_link + '\'' +
                    ", wish='" + wish + '\'' +
                    ", tutor='" + tutor + '\'' +
                    '}';
        }


        //    省略get、set


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLearning_type() {
        return learning_type;
    }

    public void setLearning_type(String learning_type) {
        this.learning_type = learning_type;
    }

    public Long getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(Long entrance_time) {
        this.entrance_time = entrance_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnline_id() {
        return online_id;
    }

    public void setOnline_id(Integer online_id) {
        this.online_id = online_id;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}

