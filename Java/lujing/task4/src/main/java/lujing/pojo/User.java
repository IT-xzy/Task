package lujing.pojo;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String salt;

    private String desPassword;

    public User(Integer id, String name, String password, String salt, String desPassword) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.desPassword = desPassword;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getDesPassword() {
        return desPassword;
    }

    public void setDesPassword(String desPassword) {
        this.desPassword = desPassword == null ? null : desPassword.trim();
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", desPassword='" + desPassword + '\'' +
                '}';
    }
}