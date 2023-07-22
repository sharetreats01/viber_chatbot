package com.sharetreats01.viber_chatbot.callback.advice;

import com.sharetreats01.viber_chatbot.userTracking.service.UserTrackingService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class CallbackControllerAspect {
    private final UserTrackingService userTrackingService;

    @Before("execution(* com.sharetreats01.viber_chatbot.controller..*(..))")
    public void trackUserActivity(JoinPoint joinPoint) {

    }
}
