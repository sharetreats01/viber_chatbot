package com.sharetreats01.viber_chatbot.enums;

public enum TreatConstant {
    TARGET,
    ME,
    FRIEND,
    RECIPIENT,
    YOUR_INFO,
    MESSAGE,
    PROMO_CODE,
    PAYMENT;

    public static TreatConstant fromValue(String value) {
        for (TreatConstant constants : values()) {
            if (constants.name().equals(value))
                return constants;
        }

        return null;
    }
}
