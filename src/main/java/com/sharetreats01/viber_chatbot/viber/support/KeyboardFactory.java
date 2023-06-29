package com.sharetreats01.viber_chatbot.viber.support;

import com.sharetreats01.viber_chatbot.interaction.enums.ActionType;
import com.sharetreats01.viber_chatbot.interaction.enums.TextHAlign;
import com.sharetreats01.viber_chatbot.interaction.enums.TextSize;
import com.sharetreats01.viber_chatbot.interaction.enums.TextVAlign;
import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import org.springframework.stereotype.Component;

@Component
public class KeyboardFactory {
    public Keyboard create() {
        return defaultCategory();
    }

    private Keyboard defaultCategory() {
        return Keyboard.builder().bgColor("#FFFFFF").defaultHeight(true)
                .buttons(new Keyboard.Button[]{
                        Keyboard.Button.builder().columns(1).rows(1).text("<br><font color=\"#494E67\"><b>ASIAN</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("ASIAN").bgColor("#f7bb3f").image("https://s18.postimg.org/9tncn0r85/sushi.png").build(),
                        Keyboard.Button.builder().columns(2).rows(1).text("<br><font color=\"#494E67\"><b>FRENCH</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("ASIAN").bgColor("#7eceea").image("https://s18.postimg.org/ntpef5syd/french.png").build(),
                        Keyboard.Button.builder().columns(3).rows(1).text("<br><font color=\"#494E67\"><b>MEXICAN</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("MEXICAN").bgColor("#f6f7f9").image("https://s18.postimg.org/t8y4g4kid/mexican.png").build(),
                        Keyboard.Button.builder().columns(1).rows(2).text("<br><font color=\"#494E67\"><b>ITALIAN</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Italian").bgColor("#dd8157").image("https://s18.postimg.org/x41iip3o5/itallian.png").build(),
                        Keyboard.Button.builder().columns(2).rows(2).text("<br><font color=\"#494E67\"><b>INDIE</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Indie").bgColor("#f6f7f9").image("https://s18.postimg.org/wq06j3jkl/indi.png").build(),
                        Keyboard.Button.builder().columns(3).rows(2).text("<br><font color=\"#494E67\"><b>MORE</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("More").bgColor("#a8aaba").image("https://s18.postimg.org/ylmyu98et/more_Options.png").build()
                })
                .build();
    }
}
