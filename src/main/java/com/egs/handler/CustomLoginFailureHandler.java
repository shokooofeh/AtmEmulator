package com.egs.handler;


import com.egs.entity.UserInfo;
import com.egs.service.UserInfoService;
import com.egs.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private UserInfoService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String userName = request.getParameter("app_username");
        UserInfo user = userService.getUserByName(userName);
        if (user != null && !user.getBlocked()){
            if (user.getRetryCount() < Constant.MAX_LOGIN_ATTEMPT) {
                userService.increaseFailedAttempts(user);
            } else {
                userService.lock(user);
                exception = new LockedException("Your account has been locked due to 3 failed attempts.");
            }
        }

        super.setDefaultFailureUrl("/login?error");
        super.onAuthenticationFailure(request, response, exception);
    }

}