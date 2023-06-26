package com.sharetreats01.viber_chatbot.viber.client;

import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofit;
import com.sharetreats01.viber_chatbot.viber.properties.ViberProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Configuration
@RequiredArgsConstructor
public class ViberClientConfig {
    private final ViberProperties viberProperties;

    @Bean
    public WebClient viberWebClient() {
        return WebClient.builder()
                .baseUrl(viberProperties.getViberApiUrl())
                .defaultHeader(viberProperties.getViberAuthHeader(), viberProperties.getViberAuthToken())
                .build();
    }

//    @Bean
    public ViberRetrofitClient viberRetrofitClient() {
        return ArmeriaRetrofit
                .builder(viberProperties.getViberApiUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(ViberRetrofitClient.class);
    }
}
