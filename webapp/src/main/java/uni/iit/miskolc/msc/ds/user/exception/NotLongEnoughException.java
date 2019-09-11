package uni.iit.miskolc.msc.ds.user.exception;

public class NotLongEnoughException extends Throwable {

    public NotLongEnoughException() {
    }

    public NotLongEnoughException(String message) {
        super(message);
    }

    public NotLongEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLongEnoughException(Throwable cause) {
        super(cause);
    }

    public NotLongEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
