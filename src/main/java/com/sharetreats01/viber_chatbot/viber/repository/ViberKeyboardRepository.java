package com.sharetreats01.viber_chatbot.viber.repository;


import com.sharetreats01.viber_chatbot.viber.enums.KeyboardType;

import java.util.Optional;

public interface ViberKeyboardRepository {
    Optional<String> findKeyboardJsonByType(KeyboardType type);
}
