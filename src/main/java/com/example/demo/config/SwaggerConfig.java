package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerApiConfig {

    @Bean
    public API customOpenAPI() {
        return new SwaggerAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("http://9005.vs.amypo.ai")
                ));
        }
}