package com.vastika.doctorservice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server gateway = new Server();
        gateway.setUrl("http://localhost:8080/doctor-service");
        gateway.setDescription("Gateway URL");
//
//        Server prodServer = new Server();
//        prodServer.setUrl(prodUrl);
//        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("taman.neupane@gmail.com");
        contact.setName("Taman Neupane");
        contact.setUrl("https://www.tamanneupane.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Doctor Service API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to doctor service.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);


        return new OpenAPI().info(info).servers(List.of(gateway));
    }
}
