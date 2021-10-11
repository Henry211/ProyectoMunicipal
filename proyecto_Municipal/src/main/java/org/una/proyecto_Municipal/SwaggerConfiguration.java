package org.una.proyecto_Municipal;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(singletonList(new ApiKey("JWT", "AUTHORIZATION", "HEADER")))
                .securityContexts(singletonList(
                        SecurityContext.builder()
                                .securityReferences(
                                        singletonList(SecurityReference.builder()
                                                .reference("JWT")
                                                .scopes(new AuthorizationScope[0])
                                                .build()
                                        )
                                )
                                .build())
                )
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.proyecto_Municipal.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Seguridad", "Metodos de Seguridad"),
                        new Tag("Funcionarios", "Entidad de Funcionarios"),
                        new Tag("Colaboradores","Entidad de Colaboradores"),
                        new Tag("Cobros", "Entidad de Cobros"),
                        new Tag("Licencias", "Entidad de Licencias"),
                        new Tag("Parametros", "Entidad de Parametros"),
                        new Tag("Propiedades", "Entidad de Propiedades"),
                        new Tag("Roles", "Entidad de Roles"),
                        new Tag("Rutas", "Entidad de Rutas"),
                        new Tag("Transacciones", "Entidad de Transacciones")
                );

    }



    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Cobro Municipal",
                "Rest API sobre Cobro Municipal.",
                "Versión:1.2.0",
                "https://una.ac.cr/api/proyecto_Municipal",
                new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr"),
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }



}
