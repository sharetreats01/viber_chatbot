package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
//        if (!StringUtils.hasText(treatPart) || !StringUtils.startsWithIgnoreCase(treatPart, "TREAT")) {
        if (input.equals("TREAT")) {
            result.add("TREAT");
        } else {
            result.addAll(new ArrayList<>(Arrays.asList(treatPart.split(DELIMITER))));
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
        int index = treatParts.size() - 3;

        if (index < path.size()) {
            return path.get(index);
        } else {
            return null;
        }
    }

    private List<String> getTreatParts(List<String> parts) {
        String treatPart = parts.get(3);
        return Arrays.asList(treatPart.split(DELIMITER));
    }
}
