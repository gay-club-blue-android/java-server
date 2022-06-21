package com.example.bfjavaserver.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

//@Configuration
public class SwaggerConfig {

    //@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("BFJavaServer")
                                .version("1.0.0")
                );
    }

}
