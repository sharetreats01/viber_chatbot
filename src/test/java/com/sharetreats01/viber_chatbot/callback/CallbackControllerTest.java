package com.sharetreats01.viber_chatbot.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharetreats01.viber_chatbot.dto.ConversationStarted;
import com.sharetreats01.viber_chatbot.dto.User;
import com.sharetreats01.viber_chatbot.dto.WelcomeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(CallbackController.class)
class CallbackControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void conversation_started_test() throws Exception {
        ConversationStarted conversationStarted = new ConversationStarted("conversation_started", 219421853L, 1232151, "text", "context", new User("#214392542542", "User", "http://www.image/avatar.img", "KR", "ko", 1), true);
        String callback = objectMapper.writeValueAsString(conversationStarted);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/sharetreats_welcome")
                .contentType(MediaType.APPLICATION_JSON)
                .content(callback))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").value("Welcome to our bot!"));

        WelcomeMessage welcomeMessage = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(), WelcomeMessage.class);
        assertThat(welcomeMessage.getSender().getName()).isEqualTo("John McClane");
    }
}