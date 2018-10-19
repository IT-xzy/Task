package task05.pojo;


public class UserLogin {
    int id;

    String name;

    String password;

    String salt;

    String despassword;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDespassword() {
        return despassword;
    }

    public void setDespassword(String despassword) {
        this.despassword = despassword;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", despassword='" + despassword + '\'' +
                '}';
    }
}
