package com.sharetreats01.viber_chatbot.template.body;

import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import lombok.Getter;


@Getter
public class PhotoTypeMessage extends MessageBody{

    private String text;
    private String media;
    private String thumbnail;
    public PhotoTypeMessage(OrderSuccessResponse successResponse) {
        super("picture");
        this.text = successResponse.toPictureBodyString();
        this.media = successResponse.getProductUrl();
        this.thumbnail = successResponse.getProductUrl();
    }

}
