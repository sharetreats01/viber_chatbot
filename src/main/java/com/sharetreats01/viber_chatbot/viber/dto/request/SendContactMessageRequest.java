package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Contact;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendContactMessageRequest extends SendMessageRequest {
    private final String type = "contact";
    private final Contact contact;

    public SendContactMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Contact contact) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.contact = contact;
    }
}
