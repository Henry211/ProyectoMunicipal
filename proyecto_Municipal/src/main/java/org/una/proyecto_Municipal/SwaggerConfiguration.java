package org.una.proyecto_Municipal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.proyecto_municipal.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Seguridad", "Metodos de Seguridad"),
                        new Tag("Colaboradores", "Entidad de Colaboradores"),
                        new Tag("Licencias", "Entidad de Licencias"),
                        new Tag("Roles", "Entidad de Roles"),
                        new Tag("Transacciones", "Entidad de Transacciones")
                );

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Cobro Municipal",
                "Rest API sobre Cobro Municipal.",
                "Versión:1.2.0",
                "https://una.ac.cr/api/proyecto_municipal",
                new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr"),
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}
