package com.kaeser.platform.ucodigo.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi(){
        //General Configuration
        var openApi = new OpenAPI();

        openApi.info(new Info()
                        .title("KAESER ")
                        .description("Keser API")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))

                .externalDocs(new ExternalDocumentation()
                        .description(" ... Documentation")
                        .url("https://kaeser-platform.wiki.github.io/docs"));
        return openApi;
    }
}
