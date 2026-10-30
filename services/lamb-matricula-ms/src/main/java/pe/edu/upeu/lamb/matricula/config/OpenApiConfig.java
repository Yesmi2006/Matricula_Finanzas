package pe.edu.upeu.lamb.matricula.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private static final String ESQUEMA_JWT = "bearerAuth";

    // Orden fijo de los grupos de controladores en Swagger UI
    private static final List<Tag> TAGS = List.of(
            new Tag().name("situacion-del-estudiante-controller"),
            new Tag().name("reglas-y-requisitos-controller"),
            new Tag().name("rectificacion-retiro-y-reactivacion-controller"),
            new Tag().name("oferta-y-cupos-controller"),
            new Tag().name("matricula-controller"),
            new Tag().name("cursos-y-carga-academica-controller"),
            new Tag().name("calendario-y-periodos-controller"));

    // Boton Authorize en Swagger UI para enviar el JWT
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes(ESQUEMA_JWT,
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList(ESQUEMA_JWT))
                .tags(TAGS);
    }
}
