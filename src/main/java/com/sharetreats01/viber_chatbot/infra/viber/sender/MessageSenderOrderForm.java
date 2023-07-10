package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.template.body.KeyBoardBody;
import com.sharetreats01.viber_chatbot.template.body.component.Button;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.order.enums.OrderFormState;
import com.sharetreats01.viber_chatbot.order.util.OrderTrackingDataUtil;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageSenderOrderForm extends AbstractMessageSender implements MessageSender{
    public final ProductService productService;
    public MessageSenderOrderForm(ViberWebClient webClient, ChatbotProperties chatbotProperties,
        ProductService productService) {
        super(webClient, chatbotProperties);
        this.productService = productService;
    }

    @Override
    public State getSenderKey() {
        return State.ORDER;
    }
    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        String trackingData = request.getMessage().getTrackingData();
        OrderFormState curState = OrderTrackingDataUtil.getOrderState(trackingData);
        String keyboard = "";

        if (curState == OrderFormState.FORM_END) {
            keyboard = keyboard2JsonString(createPaymentKeyboard(trackingData));
            trackingData = TrackingDataUtils
                .updateNextState(trackingData, State.PAYMENT);
        } else{
            curState = OrderFormState.next(curState);
            trackingData = OrderTrackingDataUtil.updateValue(trackingData,request.getMessage().getText());
        }
        SendTextMessageRequest messageRequest = new SendTextMessageRequest(
            request.getSender().getId(),
            request.getSender().getName(),
            request.getSender().getAvatar(),
            request.getSender().getApiVersion(),
            curState.getTextMessage(),
            trackingData
        );

        if (!keyboard.isBlank()){
            messageRequest.setKeyboard(keyboard);
        }

        return messageRequest;

    }

    private KeyBoardBody createPaymentKeyboard(String trackingData) {
        String productId = OrderTrackingDataUtil.getProductId(trackingData);
        AvailablePaymentsResponse response = productService.getPaymentList(productId);

        List<Button> buttons = response.getPayments().stream()
            .map(payment -> new Button.paymentBuilder()
                .payementId(payment.getId())
                .name(payment.getName())
                .originPrice(payment.getOriginPrice())
                .discountedPrice(payment.getDiscountPrice())
                .discounted(payment.isDiscounted())
                .build()
            )
            .collect(Collectors.toList());

        return KeyBoardBody.builder()
            .buttons(buttons)
            .build();
    }

    /**
     * @deprecated
     * **임시** keyboard를 json으로 변환시키는 메소드
     * @return keyboard String
     */
    private static String keyboard2JsonString(KeyBoardBody keyBoardBody){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(keyBoardBody);
        }catch (JsonProcessingException je) {
            return null;
        }
    }
}
