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
    private static final String DELIMITER = " ";

    public String updateTreatData(String trackingData, String input) {
        return trackingData + DELIMITER + input.trim();
    }

    public List<String> combineTreatData(String trackingData, String input) {
        String[] parts = trackingData.split(":");
        String lastPart = parts[parts.length - 1];

        if (!lastPart.startsWith("TREAT")) return new ArrayList<>(List.of("TREAT"));
        else return new ArrayList<>(Arrays.asList((lastPart + DELIMITER + input.trim()).split(DELIMITER)));
    }

    public List<String> deleteLastInput(List<String> treatParts) {
        treatParts.remove(treatParts.size() - 1);
        return treatParts;
    }

    public String getTreatLinkerIdentifier(List<String> treatParts) {
        if (treatParts.size() == 0) return null;
        else if (treatParts.size() == 1) return treatParts.get(0);
        else return treatParts.get(1);
    }

    public String treatPartsToString(List<String> treatParts) {
        return String.join(DELIMITER, treatParts);
    }

    public TreatConstant getTreatConstant(List<String> treatParts) {
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
}
