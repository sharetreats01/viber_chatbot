package com.sharetreats01.viber_chatbot.sharetreats.service;

import com.sharetreats01.viber_chatbot.sharetreats.repository.SharetreatsBrandRepository;
import com.sharetreats01.viber_chatbot.sharetreats.repository.SharetreatsCategoryRepository;
import com.sharetreats01.viber_chatbot.sharetreats.repository.SharetreatsProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SharetreatsService {
    private final SharetreatsBrandRepository brandRepository;
    private final SharetreatsProductRepository productRepository;
    private final SharetreatsCategoryRepository categoryRepository;
}
