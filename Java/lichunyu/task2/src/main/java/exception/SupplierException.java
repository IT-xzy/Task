package exception;
/**
 * 自定义处理supplier类的异常
 * 针对预期的异常，在程序中抛出
 */
public class SupplierException extends Exception {
//异常信息
    public String message;
//构造器
    public SupplierException(String message){
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
