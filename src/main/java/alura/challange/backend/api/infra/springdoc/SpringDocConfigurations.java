package alura.challange.backend.api.infra.springdoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("ChallangeAlura API")
                        .description("API Rest do desafio da Alura Back End, contendo as funcionalidades de CRUD de Depoimentos e de Destinos.")
                        .contact(new Contact()
                                .name("Vinicius Silva de Oliveira")
                                .email("tiviniciusoliveira@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://challange.alura/api/licenca")));
    }
}
