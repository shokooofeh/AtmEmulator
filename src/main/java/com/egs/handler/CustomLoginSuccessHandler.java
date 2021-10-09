package com.egs.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.egs.entity.UserInfo;
import com.egs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserInfoService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserInfo userDetails =  (UserInfo) authentication.getPrincipal();
        UserInfo user = userService.getUserByName(userDetails.getUserName());
        if (user.getRetryCount() > 0) {
            userService.resetFailedAttempts(user.getUserName());
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

}