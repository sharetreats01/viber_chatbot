package com.sharetreats01.viber_chatbot.viber.service;

import com.sharetreats01.viber_chatbot.viber.enums.KeyboardType;
import com.sharetreats01.viber_chatbot.viber.repository.ViberKeyboardRepository;
import com.sharetreats01.viber_chatbot.viber.support.KeyboardFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeyBoardService {
    private final ViberKeyboardRepository keyboardRepository;
    private final KeyboardFactory keyboardFactory;

    public String findCategory() {
        return keyboardRepository.findKeyboardJsonByType(KeyboardType.CATEGORY).orElseThrow();
    }
}
