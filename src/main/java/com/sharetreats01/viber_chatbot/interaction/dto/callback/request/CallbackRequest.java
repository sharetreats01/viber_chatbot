package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;


@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "event")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConversationStartedRequest.class, name = "conversation_started"),
        @JsonSubTypes.Type(value = DeliveredRequest.class, name = "delivered"),
        @JsonSubTypes.Type(value = FailedRequest.class, name = "failed"),
        @JsonSubTypes.Type(value = MessageRequest.class, name = "message"),
        @JsonSubTypes.Type(value = SeenRequest.class, name = "seen"),
        @JsonSubTypes.Type(value = SubscribedRequest.class, name = "subscribed"),
        @JsonSubTypes.Type(value = UnsubscribedRequest.class, name = "unsubscribed")
})
public class CallbackRequest {
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("message_token")
    private Long messageToken;
}
