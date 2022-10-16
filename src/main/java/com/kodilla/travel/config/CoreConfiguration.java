package com.kodilla.travel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableScheduling
public class CoreConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
