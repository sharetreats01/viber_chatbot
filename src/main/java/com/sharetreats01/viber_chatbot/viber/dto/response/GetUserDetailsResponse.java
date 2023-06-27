package com.sharetreats01.viber_chatbot.viber.dto.response;

import com.sharetreats01.viber_chatbot.user.dto.User;
import com.sharetreats01.viber_chatbot.viber.enums.Status;
import lombok.Getter;

@Getter
public class GetUserDetailsResponse extends ViberResponse {
    private final Long messageToken;
    private final User user;

    public GetUserDetailsResponse(Status status, String statusMessage, Long messageToken, User user) {
        super(status, statusMessage);
        this.messageToken = messageToken;
        this.user = user;
    }

    @Override
    public String toString() {
        return "GetUserDetailsResponse{" +
                "status=" + super.getStatus() +
                ", statusMessage=" + super.getStatusMessage() +
                ", messageToken=" + messageToken +
                ", user=" + user +
                '}';
    }
}
