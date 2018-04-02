package lujing.util;

/**
 * @author lujing
 * Create_at 2017/12/29 14:58
 */
public class CustomException extends Exception {
    private String message;
    
    public CustomException(String message) {
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
