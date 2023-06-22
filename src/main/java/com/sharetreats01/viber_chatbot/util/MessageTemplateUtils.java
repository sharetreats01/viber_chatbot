package com.sharetreats01.viber_chatbot.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageTemplateUtils {
    private static final Pattern PATTERN = Pattern.compile("\\$\\{(\\w+)}");

    public static String processTemplate(String template, final Map<String, String> values) {
        StringBuilder result = new StringBuilder();

        Matcher matcher = PATTERN.matcher(template);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = values.get(key);

            if (value == null) {
                throw new IllegalStateException("No value provided for key: " + key);
            }

            matcher.appendReplacement(result, value);
        }

        matcher.appendTail(result);

        return result.toString();
    }

    public static Map<String, String> createTemplateValues(String[] placeHolders, String[] values) {
        if (placeHolders.length != values.length) {
            throw new IllegalArgumentException("");
        }

        Map<String, String> result = new HashMap<>();
        for(int i = 0; i < placeHolders.length; i++) {
            result.put(placeHolders[i], values[i]);
        }

        return result;
    }
}
