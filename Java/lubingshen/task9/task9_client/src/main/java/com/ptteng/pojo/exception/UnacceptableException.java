package com.ptteng.pojo.exception;


/*该类异常是用户可能造成的异常
真实项目中可以不需要这类对象，在校核失败的地方直接return带状态码的json对象即可
我还不会熟练使用json对象，所以暂时这样子弄吧*/
public class UnacceptableException extends RuntimeException {
    //异常信息
    private String message;

    public UnacceptableException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
