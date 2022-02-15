package com.example.bfjavaserver.controllers.shared;

import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private final AppsApiKeysService appsApiKeysService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        if (uri.equals("/mobile/apps/authByLoginAndPassword") == true) {
            return true;
        }

        String apiKey = request.getHeader("API_KEY");
        String deviceId = request.getHeader("DEVICE_ID");

        boolean exist = appsApiKeysService.existsByKeyAndDeviceId(apiKey, deviceId);
        if (exist == false) {
            throw CustomException.LogicException("key error");
        }

        return true;
    }
}
