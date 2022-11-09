package com.example.bfjavaserver.config;

import com.example.bfjavaserver.controllers.shared.AuthInterceptor;
import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс отвечающий за подключение дополнительных отбработчиков запросов к серверу
 */
@Configuration
@AllArgsConstructor
public class ApplicationConfig implements WebMvcConfigurer {
    /**
     * Сервис для продвинутого доступа к таблице API-ключей
     */
    private final AppsApiKeysService appsApiKeysService;

    /**
     * добавляет обработчик события, вызываемого перед каждым запросом
     * @param registry - сущность, занимающаяся добавлением обработчиков
     * @see AuthInterceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(appsApiKeysService));
    }
}
