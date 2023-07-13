package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.config.TreatDataUtilsConfiguration;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TreatDataUtils.class, TreatDataUtilsConfiguration.class})
class TreatDataUtilsTest extends AbstractMockTest {
    @Autowired
    private TreatDataUtils treatDataUtils;

    @Test
    @DisplayName("사용자에게 상품상세 메시지 전송 후 사용자로부터 TREAT 메시지를 받을 경우 TREAT 문자열 하나만 담긴 리스트를 반환")
    public void combineTreatDataTestByTreatProduct() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatProductMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> result = treatDataUtils.combineTreatData(trackingData, input);

        assertEquals(1, result.size());
        assertEquals("TREAT", result.get(0));
    }

    @Test
    @DisplayName("사용자에게 상품상세 메시지 전송 후 사용자로부터 TREAT 메시지를 받을 경우 TreatConstant.TARGET 반환")
    public void getTreatConstantTestByTreatProduct() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatProductMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);
        TreatConstant constant = treatDataUtils.getTreatConstant(treatParts);

        assertEquals(TreatConstant.TARGET, constant);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 ME로 입력")
    public void combineTreatDataTestByTreatTargetMe() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatMeMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> result = treatDataUtils.combineTreatData(trackingData, input);

        assertEquals(2, result.size());
        assertEquals("ME", result.get(1));
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 ME로 입력 후 tracking_data로 변환")
    public void treatPartsToStringTestByTreatTargetMe() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatMeMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);

        String result = treatDataUtils.treatPartsToString(treatParts);

        assertEquals("TREAT ME", result);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 입력")
    public void combineTreatDataTestByTreatTargetFriend() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> result = treatDataUtils.combineTreatData(trackingData, input);

        assertEquals(2, result.size());
        assertEquals("FRIEND", result.get(1));
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 입력 후 tracking_data로 변환")
    public void treatPartsToStringTestByTreatTargetFriend() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);

        String result = treatDataUtils.treatPartsToString(treatParts);

        assertEquals("TREAT FRIEND", result);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 설정하여 RECIPIENT 입력")
    public void combineTreatDataTestByFriendRecipient() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendRecipientMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> result = treatDataUtils.combineTreatData(trackingData, input);

        assertEquals(3, result.size());
        assertEquals("FRIEND", result.get(1));
        assertEquals("이름/010-0000-0000/이메일@주소", result.get(2));
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 설정하여 RECIPIENT 입력 후 tracking_data로 변환")
    public void treatPartsToStringTestByTreatFriendRecipient() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendRecipientMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);

        String result = treatDataUtils.treatPartsToString(treatParts);

        assertEquals("TREAT FRIEND 이름/010-0000-0000/이메일@주소", result);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 ME로 설정하여 YOUR_INFO 입력")
    public void combineTreatDataTestByMeYourInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatMeYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> result = treatDataUtils.combineTreatData(trackingData, input);

        assertEquals(3, result.size());
        assertEquals("ME", result.get(1));
        assertEquals("이름/010-0000-0000/이메일@주소", result.get(2));
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 ME로 설정하여 YOUR_INFO 입력 후 해당 프로세스가 실패하여 YOUR_INFO 삭제")
    public void deleteLastInputTestByMeYouInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatMeYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);
        List<String> result = treatDataUtils.deleteLastInput(treatParts);

        assertEquals(2, result.size());
        assertEquals("ME", result.get(1));
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 ME로 설정하여 YOUR_INFO 입력 후 tracking_data로 변환")
    public void treatPartsToStringTestByTreatMeYourInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatMeYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);

        String result = treatDataUtils.treatPartsToString(treatParts);

        assertEquals("TREAT ME 이름/010-0000-0000/이메일@주소", result);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 ME로 설정하여 YOUR_INFO 입력 후 TreatConstants.YOUR_INFO 반환")
    public void getTreatConstantTestByTreatMeYourInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatMeYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);
        TreatConstant result = treatDataUtils.getTreatConstant(treatParts);

        assertEquals(TreatConstant.YOUR_INFO, result);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 설정하여 YOUR_INFO 입력")
    public void combineTreatDataTestByTreatFriendYourInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> result = treatDataUtils.combineTreatData(trackingData, input);

        assertEquals(4, result.size());
        assertEquals("FRIEND", result.get(1));
        assertEquals("이름/010-0000-0000/이메일@주소", result.get(2));
        assertEquals("이름/010-0000-0000/이메일@주소", result.get(3));
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 설정하여 YOUR_INFO 입력 후 tracking_data로 변환")
    public void treatPartsToStringTestByTreatFriendYourInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);
        String result = treatDataUtils.treatPartsToString(treatParts);

        assertEquals("TREAT FRIEND 이름/010-0000-0000/이메일@주소 이름/010-0000-0000/이메일@주소", result);
    }

    @Test
    @DisplayName("사용자가 TREAT 대상을 FRIEND로 설정하여 YOUR_INFO 입력 후 TreatConstants.YOUR_INFO 반환")
    public void getTreatConstantTestByTreatFriendYourInfo() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatFriendYourInfoMessageRequest.json");
        String trackingData  = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        List<String> treatParts = treatDataUtils.combineTreatData(trackingData, input);
        System.out.println(treatParts);
        TreatConstant result = treatDataUtils.getTreatConstant(treatParts);

        assertEquals(TreatConstant.YOUR_INFO, result);
    }
}