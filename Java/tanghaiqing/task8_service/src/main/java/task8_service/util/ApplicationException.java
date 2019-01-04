package task8_service.util;

public class ApplicationException extends RuntimeException {
    public ApplicationException() {
    }
    public ApplicationException(String message) {
        super(message);
    }
}
