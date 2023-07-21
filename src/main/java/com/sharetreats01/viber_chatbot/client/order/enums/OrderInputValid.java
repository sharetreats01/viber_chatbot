package com.sharetreats01.viber_chatbot.client.order.enums;

public enum OrderInputValid {
    NAME(""), // 7자 이하
    PHONE("") //0917xxxxxxx
    ,EMAIL(""); // email

    private String regx;

    OrderInputValid(String regx) {
        this.regx = regx;
    }
}
