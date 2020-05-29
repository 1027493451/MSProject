package com.imooc2.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-23 17:36
 * @Param $
 * @return $
 * @Version 1.0
 **/
public class CookieUtil {

    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           Integer maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request,
                             String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
