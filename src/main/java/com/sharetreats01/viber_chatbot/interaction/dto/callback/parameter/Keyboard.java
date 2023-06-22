package com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.interaction.enums.*;
import com.sharetreats01.viber_chatbot.interaction.enums.internal.browser.ActionButton;
import com.sharetreats01.viber_chatbot.interaction.enums.internal.browser.FooterType;
import com.sharetreats01.viber_chatbot.interaction.enums.internal.browser.Mode;
import com.sharetreats01.viber_chatbot.interaction.enums.internal.browser.TitleType;
import com.sharetreats01.viber_chatbot.interaction.enums.favorite.metadata.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * api level 3 은 Viber 7.6 버전이상에서만 지원
 * api level 3 이상의 매개변수를 사용하려면 min_api_version 매개변수 필요
 */

@Builder
@Getter
@AllArgsConstructor
public class Keyboard {
    @JsonProperty("BgColor")
    private final String bgColor;
    @JsonProperty("DefaultHeight")
    private Boolean defaultHeight;
    @JsonProperty("CustomDefaultHeight")
    private Integer customDefaultHeight;
    @JsonProperty("HeightScale")
    private Integer heightScale;
    @JsonProperty("ButtonsGroupColumns")
    private Integer buttonsGroupColumns;
    @JsonProperty("ButtonsGroupRows")
    private Integer buttonsGroupRows;
    @JsonProperty("InputFieldState")
    private String inputFieldState;
    @JsonProperty("FavoritesMetadata")
    private FavoritesMetadata favoritesMetadata;
    @JsonProperty("Buttons")
    private final Button[] buttons;

    @Getter
    @AllArgsConstructor
    public static class FavoritesMetadata {
        private final Type type;
        private final String url;
        private String title;
        private String thumbnail;
        private String domain;
        private Integer width;
        private Integer height;
        @JsonProperty("alternativeUrl")
        private String alternativeUrl;
        @JsonProperty("alternativeText")
        private String alternativeText;
        @JsonProperty("minApiVersion")
        private Integer minApiVersion;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class Button {
        @JsonProperty("Columns")
        private Integer columns;
        @JsonProperty("Rows")
        private Integer rows;
        @JsonProperty("BgColor")
        private String bgColor;
        @JsonProperty("Silent")
        private String silent;
        @JsonProperty("BgMediaType")
        private MediaType bgMediaType;
        @JsonProperty("BgMedia")
        private String bgMedia;
        @JsonProperty("BgMediaScaleType")
        private ScaleType bgMediaScaleType;
        @JsonProperty("ImageScaleType")
        private ScaleType imageScaleType;
        @JsonProperty("BgLoop")
        private Boolean bgLoop;
        @JsonProperty("ActionType")
        private ActionType actionType;
        @JsonProperty("ActionBody")
        private final String actionBody;
        @JsonProperty("Image")
        private String image;
        @JsonProperty("Text")
        private String text;
        @JsonProperty("TextVAlign")
        private TextVAlign textVAlign;
        @JsonProperty("TextHAlign")
        private TextHAlign textHAlign;
        @JsonProperty("TextPaddings")
        private Integer[] textPaddings;
        @JsonProperty("TextOpacity")
        private Integer textOpacity;
        @JsonProperty("TextSize")
        private TextSize textSize;
        @JsonProperty("OpenURLType")
        private URLType openURLType;
        @JsonProperty("OpenURLMediaType")
        private URLMediaType openURLMediaType;
        @JsonProperty("TextBgGradientColor")
        private String textBgGradientColor;
        @JsonProperty("TextShouldFit")
        private Boolean textShouldFit;
        @JsonProperty("InternalBrowser")
        private InternalBrowser internalBrowser;
        @JsonProperty("Map")
        private Map map;
        @JsonProperty("Frame")
        private Frame frame;
        @JsonProperty("MediaPlayer")
        private MediaPlayer mediaPlayer;

        @Getter
        @Builder
        @AllArgsConstructor
        public static class InternalBrowser {
            @JsonProperty("ActionButton")
            private ActionButton actionButton;
            @JsonProperty("ActionPredefinedURL")
            private String actionPredefinedURL;
            @JsonProperty("TitleType")
            private TitleType titleType;
            @JsonProperty("CustomTitle")
            private String customTitle;
            @JsonProperty("Mode")
            private Mode mode;
            @JsonProperty("FooterType")
            private FooterType footerType;
            @JsonProperty("ActionReplyData")
            private String actionReplyData;
        }

        @Getter
        @Builder
        @AllArgsConstructor
        public static class Map {
            @JsonProperty("Latitude")
            private String latitude;
            @JsonProperty("Longitude")
            private String longitude;
        }

        @Getter
        @Builder
        @AllArgsConstructor
        public static class Frame {
            @JsonProperty("BorderWidth")
            private String borderWidth;
            @JsonProperty("BorderColor")
            private String borderColor;
            @JsonProperty("CornerRadius")
            private String cornerRadius;
        }

        @Getter
        @Builder
        @AllArgsConstructor
        public static class MediaPlayer {
            @JsonProperty("Title")
            private String title;
            @JsonProperty("Subtitle")
            private String subtitle;
            @JsonProperty("ThumbnailURL")
            private String thumbnailURL;
            @JsonProperty("Loop")
            private Boolean loop;
        }
    }
}
