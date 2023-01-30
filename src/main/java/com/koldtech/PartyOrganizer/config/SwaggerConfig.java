package com.koldtech.PartyOrganizer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Party Bot API")
                .description("API for bot that organizes parties")
                .version("0.1")
                .contact(apiContact())
                .license(apiLicence());
    }

    private License apiLicence() {
        return new License()
                .name("Apache License 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0.html");
    }

    private Contact apiContact() {
        return new Contact()
                .name("Adam Kasperovich")
                .email("akasperovich1@gmail.com")
                .extensions(Collections.singletonMap("url","https://www.koldtech.ca/"));
    }
}