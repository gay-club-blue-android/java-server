package com.example.bfjavaserver.controllers.shared;

import com.example.bfjavaserver.models.AppApiKey;
import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.currentTimeMillis;

@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    private final AppsApiKeysService appsApiKeysService;

    /**
     * проверяет валидность пары apikey и deviceid при каждом запросе
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        Path path = Paths.get(uri);
        boolean isSwaggerFile = (path.startsWith("/swagger-ui") &&
                (uri.endsWith(".html") || uri.endsWith(".css") || uri.endsWith(".js")||uri.endsWith(".png")))|| uri.equals("/v3/api-docs/swagger-config")
                ||uri.equals("/v3/api-docs") || uri.equals("/swagger-ui.html");
        if (uri.equals("/mobile/apps/authByLoginAndPassword")||isSwaggerFile) {
            return true;
        }
        String apiKey = request.getHeader("API_KEY");
        String deviceId = request.getHeader("DEVICE_ID");

        AppApiKey appApiKey = appsApiKeysService.getByKeyAndDeviceId(apiKey, deviceId);

        if (appApiKey == null) {
            throw CustomException.LogicException("apikey not found");
        }

        /*long timestamp = currentTimeMillis();

        if (timestamp > appApiKey.finishTime) {
            throw CustomException.LogicException("app key expired");
        }*/

        return true;
    }
}
