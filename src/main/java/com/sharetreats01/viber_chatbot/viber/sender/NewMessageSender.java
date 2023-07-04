package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.interaction.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.KeyBoardService;
import org.springframework.stereotype.Component;

@Component
public class NewMessageSender extends AbstractMessageSender implements MessageSender {
    private final UserService userService;
    private final KeyBoardService keyBoardService;

    public NewMessageSender(ViberWebClient webClient, UserService userService, KeyBoardService keyBoardService) {
        super(webClient);
        this.userService = userService;
        this.keyBoardService = keyBoardService;
    }

    @Override
    public State getSenderKey() {
        return null;
    }

    @Override
    public void send(MessageRequest request) {
        userService.subscribe(request.getSender().getId());
        super.sendResponse(request);
    }


    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        String keyboard = keyBoardService.findBrands();
        SendTextMessageRequest textMessageRequest =
                new SendTextMessageRequest(request.getSender().getId(), "Viber Treats", "", request.getSender().getApiVersion(), "Thank you for Subscribe!", TrackingDataUtils.updateState(request.getMessage().getTrackingData(), State.NEW));
        textMessageRequest.setKeyboard(keyboard);

        return textMessageRequest;
    }
}
