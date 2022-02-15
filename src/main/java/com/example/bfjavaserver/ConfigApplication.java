package com.example.bfjavaserver;

import com.example.bfjavaserver.controllers.shared.AuthInterceptor;
import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class ConfigApplication implements WebMvcConfigurer {

    @Autowired
    private final AppsApiKeysService appsApiKeysService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(appsApiKeysService));
    }
}
