package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.Sender;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.order.dto.OrderDataDto;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class TreatDataUtils {
    private final Map<TreatConstant, List<TreatConstant>> treatPaths;
    private final String DELIMITER = " ";
    private final String TRACKING_DELIMITER = ":";
    private final Integer TREAT_PART_INDEX = 3;

    public String updateTreatData(String trackingData, String input) {
        return trackingData + DELIMITER + input.trim();
    }

    public List<String> combineTreatData(String trackingData, String input) {
        String[] parts = trackingData.split(TRACKING_DELIMITER);
        String treatPart = parts[parts.length - 1];

        List<String> result = new ArrayList<>(Arrays.asList(parts));
        if (input.equals("TREAT")) {
            result.add("TREAT");
        } else {
            List<String> treatData = new ArrayList<>(Arrays.asList(treatPart.split(DELIMITER)));
            result.addAll(treatData);
            result.add(input);
        }
        return result;
    }

    public List<String> deleteLastInput(List<String> parts) {
        parts.remove(parts.size() - 1);
        return parts;
    }

    public String getTreatLinkerIdentifier(List<String> parts) {
        List<String> treatParts = getTreatParts(parts);

        if (treatParts.size() < 2) return treatParts.get(0);
        return treatParts.get(1);
    }

    public String combinePartsToTrackingData(List<String> parts) {
        return String.join(TRACKING_DELIMITER, parts);
    }


    public TreatConstant getTreatConstant(List<String> parts) {
        List<String> treatParts = getTreatParts(parts);

        if (treatParts.size() < 2) return TreatConstant.TARGET;
        TreatConstant constants = TreatConstant.fromValue(treatParts.get(1));
        List<TreatConstant> path = treatPaths.get(constants);
        int index = treatParts.size() - 2;

        if (index < path.size()) {
            return path.get(index);
        } else {
            return null;
        }
    }
    private List<String> getTreatParts(List<String> parts) {
        String treatPart = parts.stream()
            .filter(s -> s.startsWith(State.TREAT.name()))
            .findFirst()
            .orElse(State.TREAT.name());
        return new ArrayList<String>(Arrays.asList(treatPart.split(DELIMITER)));
    }
    public TreatConstant getNextTreatConstant(List<String> treatParts, String input) {
        List<String> treatData = getTreatParts(treatParts);
        treatData.add(input);
        if (treatData.size() < 2) return TreatConstant.TARGET;

        TreatConstant curLinker = TreatConstant.fromValue(treatData.get(1));
        List<TreatConstant> treatPath = treatPaths.get(curLinker);
        int curTreatIndex = treatData.size() - 3;
        if (curTreatIndex + 1 < treatPath.size()) {
            return treatPath.get(curTreatIndex + 1);
        }
        return TreatConstant.END;
    }

    public String getProductId(List<String> treatParts) {
        String detailPart = treatParts.stream()
            .filter(s -> s.startsWith(State.DETAIL.name()))
            .findFirst()
            .orElse("");
        return detailPart.trim().split("_")[1];
    }

    public OrderByBotRequest mapToOrderRequest(MessageRequest request, List<String> combinedTreatParts) {
        Sender viberUser =  request.getSender();

        List<String> treatData = getTreatParts(combinedTreatParts);
        treatData.add(combinedTreatParts.get(combinedTreatParts.size() - 1));
        String productId = getProductId(combinedTreatParts);

        OrderDataDto orderData = new OrderDataDto.builder(treatData).build();
        return OrderByBotRequest.builder()
                .productId(productId)
                .viberId(viberUser.getId())
                .receiverName(orderData.getReceiverName())
                .receiverPhone(orderData.getReceiverPhone())
                .email(orderData.getReceiverEmail())
                .giverName(orderData.getGiverName())
                .giverPhone(orderData.getGiverPhone())
                .message(orderData.getMessage())
                .paymentId(orderData.getPaymentId())
                .promoCode(orderData.getPromoCode())
                .build();
    }
}
