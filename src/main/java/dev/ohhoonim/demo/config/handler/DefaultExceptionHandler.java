package dev.ohhoonim.demo.config.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    DefaultResponseBody defaultErrorHandler(HttpServletRequest request, Exception e)
            throws Exception {
        return DefaultResponseBody.builder()
                .code("ERR0001")
                .message(e.getMessage())
                .data(null)
                .description("fail")
        .build();
    }
}
