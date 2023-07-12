package com.sharetreats01.viber_chatbot.order.util;
import com.linecorp.armeria.internal.shaded.fastutil.Hash;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.enums.OrderFormState;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import okio.Options;

@Slf4j
public class OrderTrackingDataUtil {
    private static final String VALUE_SEPARATOR = "-";
    private static final String PARAMETER_SEPARATOR = "_";

    private static OrderFormState DEFAULT_STATE = OrderFormState.INPUT_RECEIVER;

    /**
     * orderState를 반환하는 함수,
     * @param trackingData
     */
    public static OrderFormState getOrderState(String trackingData) {
        String[] values = OrderTrackingDataUtil.getOrderValues(trackingData);
        return OrderFormState.getStateByIndex(Integer.valueOf(values.length));
    }

    /**
     * 
     * @param trackingData
     * @return order 뒤에 붙은 여러 String[values] 를 가져오는 역할
     */
    private static String[] getOrderValues(String trackingData){
        String[] parts = trackingData.split(":");
        String[] orderParts = parts[parts.length - 1].split(VALUE_SEPARATOR);
        if(orderParts.length < 2) {
            return new String[0];
        }
        return orderParts[1].split(PARAMETER_SEPARATOR);
    }

    public static String updateValue(String trackingData, String newData){
        return trackingData + PARAMETER_SEPARATOR + newData;
    }

    public static String getProductId(String trackingData) {
        Optional<String> line = Arrays
            .stream(trackingData.split(":"))
            .filter(str -> str.startsWith(State.PRODUCT_DETAIL.getValue()))
            .findFirst();

        if (line.isPresent()) {
            String productId = line.get().split("-")[1];
            return productId.isBlank()? "" : productId;
        }
        return "";
    }

    private static HashMap<String, String> getOrderData(String trackingData){
        HashMap<String, String> orderMap = new HashMap<String, String>();

        Optional<String> data = Arrays
            .stream(trackingData.split(":"))
            .filter(str -> str.startsWith(State.ORDER.getValue()))
            .findFirst();
        if (data.isEmpty()) {
            return orderMap;
        }
        String[] datum = data.get().split("-")[1].split("_");

        String[] receiverData = datum[0].split("/");
        String[] giverData = datum[1].split("/");
        String message = datum[2];
        String promoCode = "N".equals(datum[3]) ? "" : datum[3] ;

        orderMap.put("receiverName",receiverData[0]);
        orderMap.put("receiverPhone",receiverData[1]);
        orderMap.put("giverName", giverData[0]);
        orderMap.put("giverPhone", giverData[1]);
        orderMap.put("message", message);

        if (receiverData.length > 2) {
            orderMap.put("receiverEmail", receiverData[2]);
        }
        if (giverData.length > 2) {
            orderMap.put("giverEmail", giverData[2]);
        }
        if (!promoCode.isBlank()){
            orderMap.put("promoCode", promoCode);
        }
        return orderMap;
    }

    public static OrderByBotRequest trackingData2OrderRequest(
        MessageRequest request, String paymentId) {
        String trackingData = request.getMessage().getTrackingData();
        HashMap<String, String> orderMap = getOrderData(trackingData);
        String productId = getProductId(trackingData);

        OrderByBotRequest orderByBotRequest = OrderByBotRequest.builder()
            .viberId(request.getSender().getId())
            .productId(productId)
            .paymentId(paymentId)
            .receiverName(orderMap.get("receiverName"))
            .receiverPhone(orderMap.get("receiverPhone"))
            .giverName(orderMap.get("giverName"))
            .giverPhone(orderMap.get("giverPhone"))
            .message(orderMap.get("message"))
            .build();

        if (orderMap.containsKey("promoCode")) {
            orderByBotRequest.setPromoCode(orderMap.get("promoCode"));
        }

        return orderByBotRequest;
    }
}
