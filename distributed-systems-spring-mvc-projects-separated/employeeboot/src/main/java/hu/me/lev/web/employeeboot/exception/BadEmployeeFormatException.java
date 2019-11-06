package hu.me.lev.web.employeeboot.exception;

public class BadEmployeeFormatException extends Exception {
    public BadEmployeeFormatException() {
    }

    public BadEmployeeFormatException(String message) {
        super(message);
    }

    public BadEmployeeFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadEmployeeFormatException(Throwable cause) {
        super(cause);
    }

    public BadEmployeeFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
