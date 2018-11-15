package task6_redis.util;

public class ApplicationException extends RuntimeException {
    public ApplicationException() {
    }
    public ApplicationException(String message) {
        super(message);
    }
}
