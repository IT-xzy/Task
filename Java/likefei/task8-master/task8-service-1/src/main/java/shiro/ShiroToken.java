package shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

public class ShiroToken extends UsernamePasswordToken implements Serializable{

    //验证的密码需要自己手动拿出来加盐然后放入token中
    private String md5saltpd;

    public String getMd5saltpd() {
        return md5saltpd;
    }

    public void setMd5saltpd(String md5saltpd) {
        this.md5saltpd = md5saltpd;
    }

    public ShiroToken(String username, String md5saltpd){
        super(username,md5saltpd);
        this.md5saltpd=md5saltpd;
    }
}
