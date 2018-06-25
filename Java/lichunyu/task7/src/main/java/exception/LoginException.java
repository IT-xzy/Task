package exception;

/**
 * 自定义登录异常类
 */
public class LoginException extends Exception{
    //异常信息
    public String message;
    //构造器
    public LoginException(String message){
        super(message);
        this.message=message;
    }
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
