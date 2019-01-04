package com.lyh.pojo;

    public class Student {
        private int id;
        private String name;
        private int qq;
        private String wish;
        private String school;
        private int enrolment_time;
        private String type;
        private String know_from;
        private int create_at;
        private int update_at;

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

        public String getWish() {
            return wish;
        }

        public void setWish(String wish) {
            this.wish = wish;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public int getEnrolment_time() {
            return enrolment_time;
        }

        public void setEnrolment_time(int enrolment_time) {
            this.enrolment_time = enrolment_time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getKnow_from() {
            return know_from;
        }

        public void setKnow_from(String know_from) {
            this.know_from = know_from;
        }

        public int getCreate_at() {
            return create_at;
        }

        public void setCreate_at(int create_at) {
            this.create_at = create_at;
        }

        public int getUpdate_at() {
            return update_at;
        }

        public void setUpdate_at(int update_at) {
            this.update_at = update_at;
        }

        @Override
        public String toString() {
            return "students[id = "+id+",name = "+name+",qq = "+qq+",wish = "+wish+",school = "+school+",enrolment_time = "+enrolment_time+"," +
                    "type = "+type+",know_from = "+know_from+",create_at = "+create_at+",update_at = "+update_at+"]";
        }
    }
