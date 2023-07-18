package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.support.enums.TreatInputValidType;
import org.springframework.stereotype.Component;

@Component
public class UserInputValidator {
    private final String SEPERATER = "/";
    private static final int MAX_NAME_LENGTH = 7;

    private static final String REGEX_EMAIL = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

    // CASE : "(^0917[0-9]{7}$){1,1}"; -> 필리핀 핸드폰번호 체계
    private static final String REGEX_PHONE = "(010|011)-\\d{3,4}-\\d{4}";

    private boolean isNameValid(String name) {
        if (name.length() > MAX_NAME_LENGTH) return false;
        return true;
    }
    private boolean isPhoneValid(String phone) {
        return phone.matches(REGEX_PHONE);
    }
    private boolean isEmailValid(String email) {
        return email.matches(REGEX_EMAIL);
    }
    public String checkPersonInfoValid(String input) {
        String[] inputs = input.split(SEPERATER);
        if (inputs.length < 2) {
            return TreatInputValidType.WRONG_INPUT.name();
        }

        String myName = inputs[0].trim();
        String myPhone = inputs[1].trim();
        String email = inputs.length == 3 ? inputs[2].trim() : "";

        if (myName.isBlank()) return TreatInputValidType.WRONG_INPUT.name();
        if (!isNameValid(myName)) return TreatInputValidType.EXCEED_NAME_LENGTH.name();

        if (myPhone.isBlank()) return TreatInputValidType.INVALID_PHONE.name();
        if (!isPhoneValid(myPhone)) return TreatInputValidType.INVALID_PHONE.name();

        if (!email.isBlank() && !isEmailValid(email)) return TreatInputValidType.INVALID_EMAIL.name();

        return TreatInputValidType.VALID_INPUT.name();
    }

    public String checkMessageValid(String input) {
        String message = input.trim();
        if(message.isBlank()) {
            return TreatInputValidType.WRONG_MESSAGE.name();
        }
        return TreatInputValidType.VALID_INPUT.name();
    }

    public String checkPromoCodeValid(String input) {
        String promoCode = input.trim();
        if (input.equals("N")) {
            return TreatInputValidType.VALID_INPUT.name();
        }
        if (promoCode.isBlank()) {
            return TreatInputValidType.INVALID_PROMO_CODE.name();
        }
        if (promoCode.length() != 11) {
            return TreatInputValidType.INVALID_PROMO_CODE.name();
        }
        return TreatInputValidType.VALID_INPUT.name();
    }
}