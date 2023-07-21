package com.sharetreats01.viber_chatbot.botMessage.service.message;

import com.sharetreats01.viber_chatbot.client.viber.repository.ViberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RichMediaService {
    private final ViberRepository repository;
    public String findProductsByBrand(String brand) {
        return repository.findProductsRichMediaByBrand(brand).orElseThrow();
    }

    public String findProductDetailByProductId(String brand, String productName) {
        return repository.findProductDetailRichMediaByBrandAndProductName(brand, productName).orElseThrow();
    }

}
