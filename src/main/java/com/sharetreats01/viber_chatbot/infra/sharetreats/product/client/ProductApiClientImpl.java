package com.sharetreats01.viber_chatbot.infra.sharetreats.product.client;

import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetProductDetailRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetProductListRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.properties.ProductApiProperties;
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

    @Override
    public ProductListResponse getProductsList(GetProductListRequest request) {
        log.info("GetProductListRequest {}", request);
        WebClient.ResponseSpec responseSpec = productApiClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(productApiProperties.getProductListUri())
                        .queryParam("partners", request.getBrand())
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, ProductListResponse.class);
    }

    @Override
    public BrandListResponse getBrandList(GetBrandRequest request) {
        WebClient.ResponseSpec responseSpec = productApiClient.get()
                .uri( uriBuilder -> uriBuilder
                        .path(productApiProperties.getBrandListUri())
                        .queryParam("order", request.getOrder())
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
        return responseResolver.messageResolve(responseSpec,BrandListResponse.class);
    }

    @Override
    public ProductDetailResponse getProductDetail(Long productId) {
        log.info("ProductDetailResponse {}", productId);
        WebClient.ResponseSpec responseSpec = productApiClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(productApiProperties.getProductDetailUri())
                        .queryParam("product", productId)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, ProductDetailResponse.class);
    }

}
