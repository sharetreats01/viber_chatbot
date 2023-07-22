package com.sharetreats01.viber_chatbot.client.viber.dto.request;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.Location;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendLocationMessageRequest extends SendMessageRequest {
    private final String type = "location";
    private final Location location;

    public SendLocationMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, String trackingData, Location location) {
        super(receiver, new Sender(senderName, senderAvatar), minApiVersion, trackingData);
        this.location = location;
    }
}
