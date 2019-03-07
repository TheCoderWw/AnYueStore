package com.springmvc.util;

import javax.servlet.http.HttpServletRequest;

public class TokenUserIdUtil {
    public static Integer getLoginerId(HttpServletRequest request) {
        return JWTUtils.getUserIdByToken(request.getHeader("Authorization"));
    }
}
