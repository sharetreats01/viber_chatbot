package com.sharetreats01.viber_chatbot.client.order.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderFormState {
    INPUT_RECEIVER(
            0,
            "please text receiver info",
            "Name/PhoneNumber/email(option)"),
    INPUT_GIVER(
        1,
        "please text your(giver) info",
        "Name/PhoneNumber/email(option)"),
    INPUT_MESSAGE(
            2,
        "please input text message for receiver",
        "ex) Have a good treats!"),
    INPUT_CODE(
            3,
        "Optional, input promo code if you have" ,
        "input promo code!"),
    FORM_END(
            4,
            "which payment method",
            "do you prefer to pay?"
    );


    private Integer index;
    private String botMessage;
    private String exampleText;

    public static final Map<Integer,OrderFormState> map = new HashMap<Integer,OrderFormState>();
    OrderFormState(Integer index, String botMessage, String exampleText) {
        this.index = index;
        this.botMessage = botMessage;
        this.exampleText = exampleText;
    }

    static {
        for(OrderFormState orderFormState: values() ) {
            map.put(orderFormState.index, orderFormState);
        }
    }
    public static OrderFormState getStateByIndex(Integer index) {
        return map.getOrDefault(index,INPUT_RECEIVER);
    }

    public String getTextMessage(){
        return botMessage + "\n" + exampleText ;
    }

    public Integer getIndex() {return index;}

    public static OrderFormState next(OrderFormState state) {
        Integer curStateIndex = state.getIndex();
        if (state == FORM_END) {
            return FORM_END;
        }
        return map.get(curStateIndex + 1);
    }

}
