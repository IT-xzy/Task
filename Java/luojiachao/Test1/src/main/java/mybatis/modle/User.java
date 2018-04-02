package mybatis.modle;


public class User {
    public User(String stu_name, String profession, String join_date, String online_id, String brother, String school, String daily, String wishing, String Qq, String Heard) {
    this.stu_name=stu_name;
    this.profession=profession;
    this.join_date=join_date;
    this.online_id=online_id;
    this.brother=brother;
    this.school=school;
    this.daily=daily;
    this.wishing=wishing;
    this.Qq=Qq;
    this.Heard=Heard;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", stu_name='" + stu_name + '\'' +
                ", profession='" + profession + '\'' +
                ", join_date='" + join_date + '\'' +
                ", online_id='" + online_id + '\'' +
                ", brother='" + brother + '\'' +
                ", school='" + school + '\'' +
                ", daily='" + daily + '\'' +
                ", wishing='" + wishing + '\'' +
                ", Qq='" + Qq + '\'' +
                ", Heard='" + Heard + '\'' +
                '}';
    }

    private int id;
    private long create_at;
    private long update_at;
    private String stu_name;
    private String profession;
    private String join_date;
    private String online_id;
    private String brother;
    private String school;
    private String daily;
    private String wishing;
    private String Qq;
    private String Heard;




    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
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

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public String getOnline_id() {
        return online_id;
    }

    public void setOnline_id(String online_id) {
        this.online_id = online_id;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getQq() {
        return Qq;
    }

    public void setQq(String Qq) {
        this.Qq = Qq;
    }

    public String getHeard() {
        return Heard;
    }

    public void setHeard(String Heard) {
        this.Heard = Heard;
    }

}
