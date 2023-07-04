package com.sharetreats01.viber_chatbot.viber.service;

import com.sharetreats01.viber_chatbot.viber.repository.ViberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RichMediaService {
    private final ViberRepository repository;
    public String findProductsByBrand(String brand) {
        return repository.findProductsRichMediaByBrand(brand).orElseThrow();
    }

    public String findProductDetailByProductId(String id) {
        return null;
    }
}
