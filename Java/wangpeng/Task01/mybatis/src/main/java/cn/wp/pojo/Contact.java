/**
 * Author：老王
 * Time：2019/3/28 18:29
 **/

package cn.wp.pojo;

public class Contact {
    private int ID;
    private String Name;
    private String Email;
    private int QQ;
    private String Gender;

    @Override
    public String toString() {
        return "Contact{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", QQ=" + QQ +
                ", Gender='" + Gender + '\'' +
                '}';
    }

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getQQ() {
        return QQ;
    }

    public void setQQ(int QQ) {
        this.QQ = QQ;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
