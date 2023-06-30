package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Location;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendLocationMessageRequest extends SendMessageRequest {
    private final String type = "location";
    private final Location location;

    public SendLocationMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Location location) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.location = location;
    }
}
