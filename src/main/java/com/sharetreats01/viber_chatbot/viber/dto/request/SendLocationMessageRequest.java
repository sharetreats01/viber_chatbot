package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Location;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendLocationMessageRequest extends SendMessageRequest {
    private final String type = "location";
    private final Location location;

    public SendLocationMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, TrackingJSONData trackingData, Location location) {
        super(receiver, senderName, senderAvatar, minApiVersion, trackingData);
        this.location = location;
    }
}
