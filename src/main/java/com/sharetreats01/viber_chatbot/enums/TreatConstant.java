package com.sharetreats01.viber_chatbot.enums;

public enum TreatConstant {
    TARGET("Choose whom,\n you want to send treat"),
    ME,
    FRIEND,
    RECIPIENT("text your friend info\nex) name/phone/email(optional)"),
    YOUR_INFO("text your info\nex) name/phone/email(optional)"),
    MESSAGE("input text message"),
    PROMO_CODE("text promo code you have"),
    PAYMENT("choose which payment button you want to pay"),
    END;

    private String textMesage;

    TreatConstant() {}
    TreatConstant(String message) {
        this.textMesage = message;
    }

    public static TreatConstant fromValue(String value) {
        for (TreatConstant constants : values()) {
            if (constants.name().equals(value))
                return constants;
        }
        return null;
    }

    public String getTextMesage() {
        return textMesage;
    }
}
