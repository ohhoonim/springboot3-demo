package dev.ohhoonim.demo.config.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = {"dev.ohhoonim.demo.controller"})
public class DefaultResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
            MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        return DefaultResponseBody.builder().code("code0001").message("success").data(body).build();
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

}
