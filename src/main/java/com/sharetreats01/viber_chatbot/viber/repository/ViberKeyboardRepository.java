package com.sharetreats01.viber_chatbot.viber.repository;



import java.util.Optional;

public interface ViberKeyboardRepository {
    Optional<String> findKeyboardJsonByType(String type);
}
