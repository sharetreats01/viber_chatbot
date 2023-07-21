package com.sharetreats01.viber_chatbot.botMessage.util;

import com.sharetreats01.viber_chatbot.callback.exception.MessageTemplateException;
import com.sharetreats01.viber_chatbot.botMessage.util.MessageTemplateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CallbackMessageTemplateUtilsTest {
    @Test
    public void processTemplateWithPlaceHolder() {
        final String template = "Hello {userName}, Welcome to our chatbot";
        final Map<String, String> values = new HashMap<>();
        values.put("userName", "Jiho");

        final String result = MessageTemplateUtils.processTemplate(template, values);

        assertEquals("Hello Jiho, Welcome to our chatbot", result);
    }

    @Test
    public void processTemplateWithMultiplePlaceHolders() {
        final String template = "Hello {userName}, Welcome to our chatbot. Today is {month}-{day}";
        final Map<String, String> values = new HashMap<>();
        final LocalDate date = LocalDate.now();
        values.put("userName", "Jiho");
        values.put("month", date.getMonth().name());
        values.put("day", date.getDayOfWeek().name());

        final String result = MessageTemplateUtils.processTemplate(template, values);

        assertEquals("Hello Jiho, Welcome to our chatbot. Today is " + date.getMonth().name() + "-" + date.getDayOfWeek(), result);
    }

    @Test
    public void processTemplateWithoutPlaceHolder() {
        final String template = "Hello, Welcome to our chatbot";
        final Map<String, String> values = new HashMap<>();
        values.put("userName", "Jiho");

        final String result = MessageTemplateUtils.processTemplate(template, values);

        assertEquals(template, result);
    }

    @Test
    public void processTemplateWithSamePrefixPlaceHolders() {
        final String template = "Hello {name1}, Welcome to our chatbot. My name is {name2}";
        final Map<String, String> values = new HashMap<>();
        values.put("name1", "Jiho");
        values.put("name2", "sharetreats");

        final String result = MessageTemplateUtils.processTemplate(template, values);

        assertEquals("Hello Jiho, Welcome to our chatbot. My name is sharetreats", result);
    }

    @Test
    public void processTemplateWithSamePlaceHolders() {
        final String template = "Hello {name}, Welcome to our chatbot. Your name is {name}";
        final Map<String, String> values = new HashMap<>();
        values.put("name", "Jiho");

        final String result = MessageTemplateUtils.processTemplate(template, values);

        assertEquals("Hello Jiho, Welcome to our chatbot. Your name is Jiho", result);
    }

    @Test
    public void processTemplateWithMissingValue() {
        final String template = "Hello {name}, Welcome to out chatbot. My name is {name2}";
        final Map<String, String> values = new HashMap<>();
        values.put("name", "Jiho");

        assertThrows(IllegalStateException.class,
                () -> MessageTemplateUtils.processTemplate(template, values),
                "No value provided for key: name2");
    }

    @Test
    public void createTemplateValue() {
        List<String> placeHolders = List.of("name", "name2");
        List<String> values = List.of("jiho", "jiho2");

        Map<String, String> result = MessageTemplateUtils.createTemplateValues(placeHolders, values);

        assertEquals("jiho2", result.get("name2"));
        assertEquals(2, result.size());
    }

    @Test
    public void createTemplateValueNotCompareParam() {
        List<String> placeHolders = List.of("name", "name2");
        List<String> values = List.of("jiho");
        assertThrows(MessageTemplateException.class, () -> MessageTemplateUtils.createTemplateValues(placeHolders, values), "");
    }

    @Test
    public void processTemplateWithCreateValue() {
        List<String> placeHolders = List.of("name", "name2");
        List<String> values = List.of("jiho", "jiho2");

        Map<String, String> valueMap = MessageTemplateUtils.createTemplateValues(placeHolders, values);
        String template = "Hello! {name}! My name is {name2}.";

        String result = MessageTemplateUtils.processTemplate(template, valueMap);
        assertEquals("Hello! jiho! My name is jiho2.", result);
    }
}