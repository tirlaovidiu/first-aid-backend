package ro.firstaid.server.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidJwtAuthenticationException.class)
    protected void exceptionHandler(InvalidJwtAuthenticationException e, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(value = GeneralException.class)
    protected void generalExceptionHandler(GeneralException e, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendError(e.getCode().value(), e.getMessage());
    }
}
