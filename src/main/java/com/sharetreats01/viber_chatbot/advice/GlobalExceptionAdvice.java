package com.sharetreats01.viber_chatbot.advice;

import com.sharetreats01.viber_chatbot.infra.viber.exception.ViberException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(ViberException.class)
    public void viberException() {
    }
}
