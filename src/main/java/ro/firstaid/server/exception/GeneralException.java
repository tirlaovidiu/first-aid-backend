package ro.firstaid.server.exception;

import org.springframework.http.HttpStatus;


public class GeneralException extends RuntimeException {
    private final String message;
    private final HttpStatus code;

    public GeneralException(String message, HttpStatus code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getCode() {
        return code;
    }
}
