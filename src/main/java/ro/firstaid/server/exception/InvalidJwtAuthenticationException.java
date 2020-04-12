package ro.firstaid.server.exception;


import lombok.Data;
import org.springframework.security.core.AuthenticationException;

@Data
public class InvalidJwtAuthenticationException extends AuthenticationException {


    public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }
}
