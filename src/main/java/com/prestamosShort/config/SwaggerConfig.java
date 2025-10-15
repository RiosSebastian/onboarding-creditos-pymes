package com.prestamosShort.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title="API PRESTAMOS",
                description = "todavia no la pense",
                termsOfService = "www.ejemplo.com/terminosyservicios",
                version = "1.0.0",
                contact = @Contact(
                        name = "atencion al cliente",
                        url = "www.ejemplo.com/atencionalcliente",
                        email = "atecionalcliente@gmail.com"
                ),
                license = @License(
                        name = "nose",
                        url ="www.ejemplo.com/license"
                )
        ),
        servers = {@Server(
                description = "DEV SERVER",
                url = "http://localhost:8080"
        ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://dominio:8080"
                )
        },
        security = @SecurityRequirement(
                name = "Secirity Token"
        )
)
@SecurityScheme(
        name="Secirity Token",
        description = "acceso por token",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
