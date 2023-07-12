package com.sharetreats01.viber_chatbot.order.validation;

import com.sharetreats01.viber_chatbot.order.enums.OrderFormState;
import org.hibernate.criterion.Order;

public class OrderDataValidation {

    public static boolean inputValidateByOrderState(OrderFormState state, String reply) {
        if (reply.isBlank()) return false;

        boolean isValid = false;
        switch (state) {
            case INPUT_RECEIVER:
                break;
            case INPUT_GIVER:
                break;
            case INPUT_MESSAGE:
                break;
            case INPUT_CODE:
                break;
            default:
                break;
        }
        return isValid;
    }
    private boolean isPersonDataValid(String reply){
        String[] inputs = reply.split("/");
        if (inputs.length < 2) return false;
        if (inputs[0].isBlank()) return false;
        if (inputs[1].isBlank()) return false;

        return false;
    }

}
