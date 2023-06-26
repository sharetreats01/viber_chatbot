package com.sharetreats01.viber_chatbot.interaction.aop;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.repository.MessageHistoryRepository;
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

    @Before("execution(* com.sharetreats01.viber_chatbot.interaction.handler..*(..))")
    public void beforeLogging(JoinPoint joinPoint) {
    }

    @AfterReturning(value = "execution(* com.sharetreats01.viber_chatbot.interaction.handler..*(..))", returning = "obj")
    public void afterLogging(JoinPoint joinPoint, Object obj) {

    }

    @AfterThrowing(value = "execution(* com.sharetreats01.viber_chatbot.interaction.handler..*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {

    }

    private Callback convert(JoinPoint joinPoint) {
        Callback callback = null;
        for (Object obj : joinPoint.getArgs()) {
            if (obj.getClass().equals(Callback.class))
                callback = (Callback) obj;
        }
        return callback;
    }
}
