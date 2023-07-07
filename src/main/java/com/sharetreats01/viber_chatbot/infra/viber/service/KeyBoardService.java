package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.sharetreats01.viber_chatbot.infra.viber.repository.ViberRepository;
import com.sharetreats01.viber_chatbot.infra.viber.enums.KeyboardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeyBoardService {
    private final ViberRepository keyboardRepository;

    public String findCategory() {
        return keyboardRepository.findKeyboardJsonByType(KeyboardType.CATEGORY.toString()).orElseThrow();
    }

    public String findBrands() {
        return keyboardRepository.findKeyboardJsonByType(KeyboardType.BRAND.toString()).orElseThrow();
    }
}
