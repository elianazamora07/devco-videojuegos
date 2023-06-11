package com.devco.eli.videojuegos.comun.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket atividadeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devco.eli.videojuegos"))
                .paths(regex("/api/tienda/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "API de Tienda de video juegos",
                "Este API es usado para un proyecto de venta de video juegos.",
                "1.0",
                "Este API es de caracter privado.",
                new Contact("Eliana Zamora",
                        "https://www.linkedin.com/in/eliana-zamora/",
                        "elianazamora9907@gmail.com"),
                "",
                "",
                new ArrayList<>()
        );

        return apiInfo;
    }
}
