package hzw.model;

    public class Student {
        private long stuId;
        private String stuName;
        private int stuQQ;
        private String stuType;
        private int stuNum;
        private long create_at;
        private long update_at;

        public long getStuId() {
            return stuId;
        }

        public void setStuId(long stuId) {
            this.stuId = stuId;
        }

        public String getStuName() {
            return stuName;
        }

        public void setStuName(String stuName) {
            this.stuName = stuName;
        }

        public int getStuQQ() {
            return stuQQ;
        }

        public void setStuQQ(int stuQQ) {
            this.stuQQ = stuQQ;
        }

        public String getStuType() {
            return stuType;
        }

        public void setStuType(String stuType) {
            this.stuType = stuType;
        }

        public int getStuNum() {
            return stuNum;
        }

        public void setStuNum(int stuNum) {
            this.stuNum = stuNum;
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

        public void Student(){
        }

        public void Student(String stuName,int stuNum){
            this.stuName = stuName;
            this.stuNum = stuNum;
        }

        public void Student(String stuName,int stuQQ,String stuType,int stuNum,long update_at){
            this.stuName = stuName;
            this.stuQQ = stuQQ;
            this.stuType = stuType;
            this.stuNum = stuNum;
            this.update_at = update_at;
        }

        public void Student(String stuName,int stuQQ,String stype,int stuNum,long create_at,long update_at){
            this.stuName = stuName;
            this.stuQQ = stuQQ;
            this.stuType = stype;
            this.stuNum = stuNum;
            this.create_at = create_at;
            this.update_at = update_at;
        }

        public void Student(long stuId,String stuName,int stuQQ,String stuType,int stuNum,long create_at,long update_at){
            this.stuName = stuName;
            this.stuQQ = stuQQ;
            this.stuType = stuType;
            this.stuNum = stuNum;
            this.create_at = create_at;
            this.update_at = update_at;
        }

        @Override
        public String toString() {
            return "Student[ id = " + stuId + "," +
                    " name = " + stuName + "," +
                    " qq = " + stuQQ + "," +
                    " type = " + stuType + "," +
                    " num = " + stuNum + "," +
                    " create_at = " + create_at + "," +
                    " update_at = " + update_at + "]\n";
        }
    }


