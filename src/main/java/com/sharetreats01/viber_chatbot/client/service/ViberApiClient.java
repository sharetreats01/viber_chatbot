package com.sharetreats01.viber_chatbot.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class ViberApiClient implements ApiClient{
    private WebClient viberClient;

    @Value("${domain.viber-api}")
    private String domain;
    private String uri;

    @Value("${auth.viber.header-name}")
    private String AUTH_HEADER;

    @Value("${auth.viber.token}")
    private String AUTH_TOKEN;

    public ViberApiClient() {
        this.viberClient = WebClient.builder()
            .baseUrl(domain)
            .defaultHeader(AUTH_HEADER,AUTH_TOKEN)
            .build();
    }
    @Override
    public boolean checkPing() {


        return false;
    }

    public void request() {

    }

    public void response() {

    }

}
