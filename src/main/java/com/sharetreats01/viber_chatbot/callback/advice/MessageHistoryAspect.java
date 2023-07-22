package com.sharetreats01.viber_chatbot.callback.advice;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.CallbackRequest;
import com.sharetreats01.viber_chatbot.callback.repository.MessageHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class MessageHistoryAspect {
    private final MessageHistoryRepository repository;

    @Before("execution(* com.sharetreats01.viber_chatbot.handler..*(..))")
    public void beforeLogging(JoinPoint joinPoint) {
    }

    @AfterReturning(value = "execution(* com.sharetreats01.viber_chatbot.handler..*(..))", returning = "obj")
    public void afterLogging(JoinPoint joinPoint, Object obj) {

    }

    @AfterThrowing(value = "execution(* com.sharetreats01.viber_chatbot.handler..*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {

    }

    private CallbackRequest convert(JoinPoint joinPoint) {
        CallbackRequest callbackRequest = null;
        for (Object obj : joinPoint.getArgs()) {
            if (obj.getClass().equals(CallbackRequest.class))
                callbackRequest = (CallbackRequest) obj;
        }
        return callbackRequest;
    }
}
