package db;

public class User {
    //用户id
    private int userid;
    //用户姓名
    private String username;
    //用户密码
    private String password;
    //获得用户id
    public int getUserid(){
        return userid;
    }
    //设置用户id
    public void setUserid(int userid){
        this.userid = userid;
    }
    //获得用户名
    public String getUsername() {
        return username;
    }
    //设置用户名
    public void setUsername(String username) {
        this.username = username;
    }
    //获得用户密码
    public String getPassword() {
        return password;
    }
    //设置用户密码
    public void setPassword(String password) {
        this.password = password;
    }
}
