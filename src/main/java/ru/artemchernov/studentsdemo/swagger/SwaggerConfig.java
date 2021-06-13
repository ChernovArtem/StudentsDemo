package ru.artemchernov.studentsdemo.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("StudentsDemo")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("tema3648@gmail.com")
                                                .name("Chernov Artem")
                                )
                );
    }

}
