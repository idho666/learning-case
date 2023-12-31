package com.idho.learningcase.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.context.annotation.Configuration;

/**
 * Updated by Idho.
 * Date: 06.04.2023
 * Time: 9:11
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Spring Playground", version = "1.0",
        contact = @Contact(name = "freddxant", email = "freddxant@email.com")),
        security = @SecurityRequirement(name = "bearerToken")
)
@SecuritySchemes(
        @SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
)
public class OpenApiConfig {
}
