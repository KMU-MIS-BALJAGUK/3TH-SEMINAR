package com.baljaguk.assignment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI memoOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Memo API")
                        .version("v1")
                        .description("메모 CRUD API 문서입니다."));
    }
}
