package com.example.epmikdemo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi servicesrestApi() {
    return GroupedOpenApi.builder()
        .group("api")
        .packagesToScan("com.example.epmikdemo")
        .pathsToMatch("/api/**")
        .build();
  }

  @Bean
  public OpenAPI apiEndPointsInfo() {
    return new OpenAPI()
        .info(new Info().title("Empik demo")
            .description("Empik demo")
            .version("v1.0.0"));
  }
}
