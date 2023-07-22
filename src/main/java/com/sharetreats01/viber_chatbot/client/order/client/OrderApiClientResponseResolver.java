package com.sharetreats01.viber_chatbot.client.order.client;

import com.sharetreats01.viber_chatbot.client.order.exception.OrderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class OrderApiClientResponseResolver {
    public <T> T messageResolve(WebClient.ResponseSpec response, Class<T> className) {
        return handleError(handleHTTPStatus(response, className)).block();
    }

    private <T> Mono<T> handleHTTPStatus(WebClient.ResponseSpec response, Class<T> className) {
        return response
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new OrderException("유효하지 않은 요청")))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new OrderException("주문 서버 에러")))
                .bodyToMono(className);
    }

    private <T> Mono<T> handleError(Mono<T> response) {
        return response.onErrorResume(error -> {
            if (error instanceof WebClientResponseException) {
                return Mono.error(new OrderException(error.getMessage()));
            } else {
                return Mono.error(error);
            }
        });
    }
}
