package jnshu.pojo;

public class EmailTemplate {
    private String host ="smtp.qq.com"; //主机地址
    private String protocol ="smtp"; //邮件传输协议smtp/pop3
    private String port ="25"; //端口25或80
    private String auth ="true"; //身份验证true
    private String user ="845634109@qq.com"; //发件人邮箱
    private String password ="pcrwyjqktiitbfba"; //发件人密码
    private String to ="1057340900@qq.com"; //收件人邮箱
    private String cc; //抄送人邮箱
    //    pcrwyjqktiitbfba
    @Override
    public String toString() {
        return "Email{" +
                "host='" + host + '\'' +
                ", protocol='" + protocol + '\'' +
                ", port='" + port + '\'' +
                ", auth='" + auth + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", to='" + to + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}