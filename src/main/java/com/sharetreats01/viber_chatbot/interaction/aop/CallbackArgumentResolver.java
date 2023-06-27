package com.sharetreats01.viber_chatbot.interaction.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.nio.charset.Charset;

@Component
@RequiredArgsConstructor
public class CallbackArgumentResolver implements HandlerMethodArgumentResolver {
    private final ObjectMapper objectMapper;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Callback.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        String body = StreamUtils.copyToString(servletWebRequest.getRequest().getInputStream(), Charset.defaultCharset());
        Callback callback = objectMapper.readValue(body, Callback.class);

        return callback;
    }
}
