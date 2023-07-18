package com.sharetreats01.viber_chatbot.order.dto;

import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderDataDto {

    private String receiverName;
    private String giverName;

    private String receiverPhone;
    private String giverPhone;

    private String giverEmail;
    private String receiverEmail;

    private String message;
    private String promoCode;

    private String paymentId;

    public static class builder {
        private String[] receiverInfo;
        private String[] giverInfo;
        private String message = "";
        private String promoCode;
        private String paymentId;
        public builder(List<String> treatPart) {
            TreatConstant treatType = TreatConstant.fromValue(treatPart.get(1));

            if(treatType == TreatConstant.ME) {
                this.receiverInfo = treatPart.get(2).split("/");
                this.giverInfo = receiverInfo;
                this.promoCode = treatPart.get(3);
                this.paymentId = treatPart.get(4);
            }else {
                this.receiverInfo = treatPart.get(2).split("/");
                this.giverInfo = treatPart.get(3).split("/");
                this.message = treatPart.get(4);
                this.promoCode = treatPart.get(5);
                this.paymentId = treatPart.get(6);
            }
        }
        public OrderDataDto build() {
            OrderDataDto orderDataDto = new OrderDataDto();
            orderDataDto.receiverName = receiverInfo[0];
            orderDataDto.giverName = giverInfo[0];

            orderDataDto.receiverPhone= receiverInfo[1];
            orderDataDto.giverPhone = giverInfo[1];

            orderDataDto.receiverEmail = receiverInfo.length > 2 ? receiverInfo[2] : "";
            orderDataDto.giverEmail = giverInfo.length > 2 ? giverInfo[2] : "";
            orderDataDto.message = message;
            orderDataDto.promoCode = promoCode;
            orderDataDto.paymentId = paymentId;

            return orderDataDto;
        }
    }
}
