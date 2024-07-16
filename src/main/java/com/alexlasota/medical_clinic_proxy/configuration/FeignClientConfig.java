package com.alexlasota.medical_clinic_proxy.configuration;

import com.alexlasota.medical_clinic_proxy.errors.CustomErrorDecoder;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 1000, 3);
    }
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}