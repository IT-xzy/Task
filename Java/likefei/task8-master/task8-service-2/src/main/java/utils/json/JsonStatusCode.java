package utils.json;

public enum JsonStatusCode {
    //    成功
    SUCCESS(200,"成功"),
    //   发生错误
    EXCEPTION(401,"发生异常");

    private int code;
    private String message;

    JsonStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
