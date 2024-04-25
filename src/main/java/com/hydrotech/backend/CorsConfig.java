package com.hydrotech.backend;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI learningPlatformOpenApi() {
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("Hydrotech - API")
                        .description("HydroTech - Learn hydroponics application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("HydroTech application wiki Documentation")
                        .url("https://HydroTech.wiki.github.io/docs"));

        return openApi;
    }

    /**
     * Configures Cross-Origin Resource Sharing (CORS) for the application.
     *
     * @param registry The CorsRegistry to configure CORS for the application.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "https://deploy-greengrow.firebaseapp.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
