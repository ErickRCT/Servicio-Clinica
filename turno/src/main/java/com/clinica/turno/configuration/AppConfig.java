package com.clinica.turno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("consumirApi")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
