package com.sharetreats01.viber_chatbot.interaction.dto.callback.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
public class WelcomeMessage {
    private final Sender sender;
    private final String trackingData;
    private final String type;
    private final String text;
    private final String media;
    private final String thumbnail;

    @Builder
    public WelcomeMessage(String senderName, String senderAvatar, String trackingData, String type, String text, String media, String thumbnail) {
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.type = type;
        this.text = text;
        this.media = media;
        this.thumbnail = thumbnail;
    }

    @Getter
    @RequiredArgsConstructor
    private static class Sender {
        private final String name;
        private final String avatar;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Sender sender = (Sender) o;

            if (!name.equals(sender.name)) return false;
            return avatar.equals(sender.avatar);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + avatar.hashCode();
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WelcomeMessage that = (WelcomeMessage) o;

        if (!sender.equals(that.sender)) return false;
        if (!trackingData.equals(that.trackingData)) return false;
        if (!type.equals(that.type)) return false;
        if (!Objects.equals(text, that.text)) return false;
        if (!Objects.equals(media, that.media)) return false;
        return Objects.equals(thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        int result = sender.hashCode();
        result = 31 * result + trackingData.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        return result;
    }
}
