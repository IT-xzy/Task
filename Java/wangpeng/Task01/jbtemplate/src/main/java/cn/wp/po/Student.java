package cn.wp.po;

public class Student {
    private int ID;
    private String Name;
    private int QQ;
    private String Type;
    private int Estimatedtime;
    private String School;
    private String Manner;
    private int Number;
    private String Daily;
    private String Wish;
    private String Counselor;
    private String Source;
    private int create_at;
    private int update_at;

    /*利用get取值方法和set赋值方法对私有变量操作，方便其他类
    调用封装其中set方法由于是赋值，会引入一个同变量类型的参数*/

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQQ() {
        return QQ;
    }

    public void setQQ(int QQ) {
        this.QQ = QQ;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getEstimatedtime() {
        return Estimatedtime;
    }

    public void setEstimatedtime(int estimatedtime) {
        Estimatedtime = estimatedtime;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getManner() {
        return Manner;
    }

    public void setManner(String manner) {
        Manner = manner;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getDaily() {
        return Daily;
    }

    public void setDaily(String daily) {
        Daily = daily;
    }

    public String getWish() {
        return Wish;
    }

    public void setWish(String wish) {
        Wish = wish;
    }

    public String getCounselor() {
        return Counselor;
    }

    public void setCounselor(String counselor) {
        Counselor = counselor;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
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

///* 1.重写，将对象以字符的形式输出2.可以用作注释
    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", QQ=" + QQ +
                ", Type='" + Type + '\'' +
                ", Estimatedtime=" + Estimatedtime +
                ", School='" + School + '\'' +
                ", Manner='" + Manner + '\'' +
                ", Number=" + Number +
                ", Daily='" + Daily + '\'' +
                ", Wish='" + Wish + '\'' +
                ", Counselor='" + Counselor + '\'' +
                ", Source='" + Source + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                "}\r\n";
    }
}
