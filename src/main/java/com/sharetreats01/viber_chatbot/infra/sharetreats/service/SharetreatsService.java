package com.sharetreats01.viber_chatbot.infra.sharetreats.service;

import com.sharetreats01.viber_chatbot.infra.sharetreats.repository.SharetreatsBrandRepository;
import com.sharetreats01.viber_chatbot.infra.sharetreats.repository.SharetreatsCategoryRepository;
import com.sharetreats01.viber_chatbot.infra.sharetreats.repository.SharetreatsProductRepository;
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
