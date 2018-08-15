package xiuzhenyuan.bean;


    public class Student {
        private Integer id;
        private Long create_at;
        private Long update_at;
        private String name;
        private Integer qq;
        private String study_type;
        private String study_id;
        private Long join_time;
        private String university;
        private String daily_link;
        private String slogen;
        private String master;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getQq() {
            return qq;
        }

        public void setQq(Integer qq) {
            this.qq = qq;
        }

        public String getStudy_type() {
            return study_type;
        }

        public void setStudy_type(String study_type) {
            this.study_type = study_type;
        }

        public String getStudy_id() {
            return study_id;
        }

        public void setStudy_id(String study_id) {
            this.study_id = study_id;
        }

        public Long getJoin_time() {
            return join_time;
        }

        public void setJoin_time(Long join_time) {
            this.join_time = join_time;
        }

        public String getUniversity() {
            return university;
        }

        public void setUniversity(String university) {
            this.university = university;
        }

        public String getDaily_link() {
            return daily_link;
        }

        public void setDaily_link(String daily_link) {
            this.daily_link = daily_link;
        }

        public String getSlogen() {
            return slogen;
        }

        public void setSlogen(String slogen) {
            this.slogen = slogen;
        }

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", create_at=" + create_at +
                    ", update_at=" + update_at +
                    ", name='" + name + '\'' +
                    ", qq=" + qq +
                    ", study_type='" + study_type + '\'' +
                    ", study_id='" + study_id + '\'' +
                    ", join_time=" + join_time +
                    ", university='" + university + '\'' +
                    ", daily_link='" + daily_link + '\'' +
                    ", slogen='" + slogen + '\'' +
                    ", master='" + master + '\'' +
                    '}';
        }

    }

