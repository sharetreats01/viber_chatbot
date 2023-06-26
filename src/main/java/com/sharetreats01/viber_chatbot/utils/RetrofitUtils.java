package com.sharetreats01.viber_chatbot.utils;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public class RetrofitUtils {
    public static <T> T execute(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();

            if (!response.isSuccessful()) {
                log.error("{}", response.raw().body());
            }

        } catch (IOException ex) {
            log.error("Call :" + call, ex);
        }

        return response.body();
    }
}
