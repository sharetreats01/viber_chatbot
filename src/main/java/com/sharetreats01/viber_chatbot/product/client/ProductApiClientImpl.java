package com.sharetreats01.viber_chatbot.product.client;

import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.properties.ProductApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductApiClientImpl implements ProductApiClient {
    private final WebClient productApiClient;
    private final ProductApiProperties productApiProperties;
    private final ProductApiClientResponseResolver responseResolver;
    @Override
    public AvailablePaymentsResponse getPaymentList(Long productId) {

        String paymentCaseUri = String.format(productApiProperties.getProductPaymentListUri(), productId.toString());

        log.info("request payment case" + paymentCaseUri);
        WebClient.ResponseSpec responseSpec = productApiClient.get()
                .uri(paymentCaseUri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, AvailablePaymentsResponse.class);
    }

}
