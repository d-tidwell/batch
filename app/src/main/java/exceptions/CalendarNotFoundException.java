package exceptions;

public class CalendarNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -912326717789387975L;

    /**
     * Exception with no message or cause.
     */
    public CalendarNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public CalendarNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public CalendarNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public CalendarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

