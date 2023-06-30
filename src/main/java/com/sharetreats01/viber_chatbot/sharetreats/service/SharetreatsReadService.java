package com.sharetreats01.viber_chatbot.sharetreats.service;

import com.sharetreats01.viber_chatbot.sharetreats.repository.SharetreatsBrandRepository;
import com.sharetreats01.viber_chatbot.sharetreats.repository.SharetreatsCategoryRepository;
import com.sharetreats01.viber_chatbot.sharetreats.repository.SharetreatsProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class SharetreatsReadService {
    private final SharetreatsBrandRepository brandRepository;
    private final SharetreatsProductRepository productRepository;
    private final SharetreatsCategoryRepository categoryRepository;


}
