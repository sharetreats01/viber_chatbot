package com.sharetreats01.viber_chatbot.viber.dto.response;

import com.sharetreats01.viber_chatbot.viber.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViberResponse {
    private Status status;
    private String statusMessage;

    @Override
    public String toString() {
        return "ViberResponse{" +

                '}';
    }
}
