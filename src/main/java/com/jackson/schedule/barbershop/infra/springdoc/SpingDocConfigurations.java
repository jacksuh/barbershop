package com.jackson.schedule.barbershop.infra.springdoc;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpingDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                .title("BarberShop")
                .description("API Rest criada para agendamento de horario/serviço na barbearia")
                .contact(new Contact()
                        .name("Jackson Santos")
                        .email("jacksonsdss@gmail.com"))
                .license(new License()
                        .name("Jackson")
                        .url("https://jacksuh.github.io/portifolio-page/")));
    }

}
