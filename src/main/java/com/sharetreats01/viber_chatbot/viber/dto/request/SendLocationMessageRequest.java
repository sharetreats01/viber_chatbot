package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Location;

import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import lombok.Getter;

@Getter
public class SendLocationMessageRequest extends SendMessageRequest {
    private final String type = "location";
    private final Location location;

    public SendLocationMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Location location) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.location = location;
    }

    public SendLocationMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Location location, Keyboard keyboard) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion, keyboard);
        this.location = location;
    }
}
