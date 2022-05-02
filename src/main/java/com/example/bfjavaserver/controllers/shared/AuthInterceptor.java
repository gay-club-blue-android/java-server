package com.example.bfjavaserver.controllers.shared;

import com.example.bfjavaserver.models.AppApiKey;
import com.example.bfjavaserver.services.mobile.AppsApiKeysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        if (uri.equals("/mobile/apps/authByLoginAndPassword") == true) {
            return true;
        }

        String apiKey = request.getHeader("API_KEY");
        String deviceId = request.getHeader("DEVICE_ID");

        AppApiKey appApiKey = appsApiKeysService.getByKeyAndDeviceId(apiKey, deviceId);

        if (appApiKey == null) {
            throw CustomException.LogicException("app key not found");
        }

        /*long timestamp = currentTimeMillis();

        if (timestamp > appApiKey.finishTime) {
            throw CustomException.LogicException("app key expired");
        }*/

        return true;
    }
}
