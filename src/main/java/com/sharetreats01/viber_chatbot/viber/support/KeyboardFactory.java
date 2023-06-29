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
        return Keyboard.builder().bgColor("#FFFFFF")
                .buttons(new Keyboard.Button[]{
                        Keyboard.Button.builder().columns(1).rows(1).text("<br><font color=\"#494E67\"><b>All</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("All").bgColor("#f3f6f4").image("https://www.sharetreats.ph/images/categories/all.png").build(),
                        Keyboard.Button.builder().columns(2).rows(1).text("<br><font color=\"#494E67\"><b>Groceries & Shop</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Groceries & Shop").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/16afcddf-c369-4f58-8959-3b321bcaab88.png.webp").build(),
                        Keyboard.Button.builder().columns(3).rows(1).text("<br><font color=\"#494E67\"><b>Food & Delivery</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Food & Delivery").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/0e7f323b-6fd5-4eca-b0a6-68d24c0e072a.png.webp").build(),
                        Keyboard.Button.builder().columns(4).rows(1).text("<br><font color=\"#494E67\"><b>Bread & Dessert</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Bread & Dessert").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/ea96ef91-9843-42c8-bafc-95dd7c22a994.png.webp").build(),
                        Keyboard.Button.builder().columns(1).rows(2).text("<br><font color=\"#494E67\"><b>Beauty & Lifestyle</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Beauty & Lifestyle").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/04c870f4-e091-4497-9028-12b095194af1.png.webp").build(),
                        Keyboard.Button.builder().columns(2).rows(2).text("<br><font color=\"#494E67\"><b>Home & Kids</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Home & Kids").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/197ef94b-20b1-4186-bb5a-6098caab3472.png.webp").build(),
                        Keyboard.Button.builder().columns(3).rows(2).text("<br><font color=\"#494E67\"><b>Digital & Appliance</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Digital & Appliance").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/238ce120-1ddd-448e-88b8-258c32ac771f.png.webp").build(),
                        Keyboard.Button.builder().columns(4).rows(2).text("<br><font color=\"#494E67\"><b>Transpo & Travel</b></font>").textSize(TextSize.LARGE).textHAlign(TextHAlign.CENTER).textVAlign(TextVAlign.MIDDLE).actionType(ActionType.REPLY).actionBody("Transpo & Travel").bgColor("#f3f6f4").image("https://nas-public.sharetreats.ph/nas/system/509abfdc-a511-4197-8984-5bbc3a1ce752.png.webp").build()
                })
                .build();
    }
}
