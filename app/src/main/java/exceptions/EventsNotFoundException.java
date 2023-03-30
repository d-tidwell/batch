package exceptions;

public class EventsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -912326717789387973L;

    /**
     * Exception with no message or cause.
     */
    public EventsNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public EventsNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public EventsNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public EventsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

