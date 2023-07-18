package com.sharetreats01.viber_chatbot.infra.sharetreats.product.client;

import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.parameter.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductApiClientTest {
    @Mock
    private ProductApiClient productApiClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Mock Server에서 제품 상세 받기")
    public void getProductDetail() {
        Long productId1 = 1L;
        Long productId2 = 2L;

        // 반환할 ProductDetailResponse 모의 객체 생성
        ProductDetailResponse expectedProductDetail1 = ProductDetailResponse.builder()
                .productId(productId1)
                .productName("Cheeseburger Solo").build();

        ProductDetailResponse expectedProductDetail2 = ProductDetailResponse.builder()
                .productId(productId2)
                .productName("Tunaburger Solo").build();

        when(productApiClient.getProductDetail(productId1)).thenReturn(expectedProductDetail1);
        when(productApiClient.getProductDetail(productId2)).thenReturn(expectedProductDetail2);

        ProductDetailResponse actualProductDetail1 = productApiClient.getProductDetail(productId1);
        ProductDetailResponse actualProductDetail2 = productApiClient.getProductDetail(productId2);

        assertEquals(expectedProductDetail1.getProductId(), actualProductDetail1.getProductId());
        assertEquals(expectedProductDetail1.getProductName(), actualProductDetail1.getProductName());
        assertEquals(expectedProductDetail2.getProductId(), actualProductDetail2.getProductId());
        assertEquals(expectedProductDetail2.getProductName(), actualProductDetail2.getProductName());
    }

    @Test
    @DisplayName("Mock Server에서 제품 리스트 받기")
    public void getProductList() {
        Long brandId1 = 1L;
        Long brandId2 = 2L;

        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product(1L, "Cheeseburger Solo", 1L,
                "McDonald's", "100", "https://example.com/1"));
        productList1.add(new Product(2L, "Tunaburger Solo", 1L,
                "McDonald's", "100", "https://example.com/1"));

        ProductListResponse expectedProductList1 = ProductListResponse.builder()
                .products(productList1)
                .build();


        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(3L, "블랙라벨폴인치즈 세트", 2L,
                "KFC", "100", "https://example.com/3"));
        productList2.add(new Product(4L, "에그징거더블다운세트", 2L,
                "KFC", "100", "https://example.com/4"));

        ProductListResponse expectedProductList2 = ProductListResponse.builder()
                .products(productList2)
                .build();


        when(productApiClient.getProductsList(brandId1)).thenReturn(expectedProductList1);
        when(productApiClient.getProductsList(brandId2)).thenReturn(expectedProductList2);

        ProductListResponse actualProductList1 = productApiClient.getProductsList(brandId1);
        ProductListResponse actualProductList2 = productApiClient.getProductsList(brandId2);


        assertEquals(expectedProductList1.getProducts().get(0).getBrandName(),
                actualProductList1.getProducts().get(0).getBrandName());
        assertEquals(expectedProductList1.getProducts().get(1).getId(),
                actualProductList1.getProducts().get(1).getId());

        assertEquals(expectedProductList2.getProducts().get(0).getBrandName(),
                actualProductList2.getProducts().get(0).getBrandName());
        assertEquals(expectedProductList2.getProducts().get(1).getId(),
                actualProductList2.getProducts().get(1).getId());
    }
}
