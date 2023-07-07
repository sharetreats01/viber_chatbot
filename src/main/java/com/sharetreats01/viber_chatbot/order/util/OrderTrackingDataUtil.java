package com.sharetreats01.viber_chatbot.order.util;
import com.sharetreats01.viber_chatbot.order.enums.OrderFormState;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

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

}
