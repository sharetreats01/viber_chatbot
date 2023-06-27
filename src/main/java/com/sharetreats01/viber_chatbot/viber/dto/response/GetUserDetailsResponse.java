package com.sharetreats01.viber_chatbot.viber.dto.response;

import com.sharetreats01.viber_chatbot.user.dto.User;
import com.sharetreats01.viber_chatbot.viber.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetUserDetailsResponse extends ViberResponse {
    private Long messageToken;
    private User user;

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
