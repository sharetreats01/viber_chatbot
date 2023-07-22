package com.sharetreats01.viber_chatbot.botMessage.service.keyboard;

import com.sharetreats01.viber_chatbot.client.viber.repository.ViberRepository;
import com.sharetreats01.viber_chatbot.client.viber.enums.KeyboardType;
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
