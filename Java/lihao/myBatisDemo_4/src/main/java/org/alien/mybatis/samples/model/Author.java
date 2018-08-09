package org.alien.mybatis.samples.model;

/**
 * @author lihoo
 * @Title: Author
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1110:52
 */

@SuppressWarnings("unused")
public class Author {
    private int id;
    private String username;
    private String password;
    private String email;
    private String bio;
    private String favouriteSection;

    public Author(){
    }

    public Author(int id, String username) {
        this.id = id;
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFavouriteSection() {
        return favouriteSection;
    }

    public void setFavouriteSection(String favouriteSection) {
        this.favouriteSection = favouriteSection;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ",username='" + username + '\'' +
                ",password='" + password + '\'' +
                ",email='" + email + '\'' +
                ",bio='" + bio + '\'' +
                ",favouriteSection='" + favouriteSection + '\'' +
                '}';
    }
}
