package spring.model;

public class User {
    private Integer id;
    private String username;
    private String userpassworld;
    private Long createAt;
    private Long updateAt;
    private Long login;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassworld='" + userpassworld + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", login=" + login +
                '}';
    }

    public Long getLogin() {
        return login;
    }

    public void setLogin(Long login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }


    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassworld() {
        return userpassworld;
    }

    public void setUserpassworld(String userpassworld) {
        this.userpassworld = userpassworld;
    }
}
