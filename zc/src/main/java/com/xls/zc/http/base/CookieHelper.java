package com.xls.zc.http.base;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**



 *
 * Cookie操作
 *
 * @author hbj
 * Created 2017/4/13 14:54
 */
public class CookieHelper {

    /**
     * 设置cookie有效期，根据需要自定义[默认1天]
     */
    private final static int COOKIE_MAX_AGE = 60 * 60 * 24;

    /**
     * httponly状态
     */
    private final static boolean HTTP_ONLY_STATE = true;

    /**
     * 删除指定cookie
     * @param name
     */
    public static void removeCookie(String name) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (name.equalsIgnoreCase(cookies[i].getName())) {
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                    break;
                }
            }
        }
    }

    /**
     * 得到指定cookie
     * @param name
     * @return
     */
    public static String getCookie(String name) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        String resValue = null;
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (name.equalsIgnoreCase(cookies[i].getName())) {
                    resValue = cookies[i].getValue();
                    break;
                }
            }
        }
        return resValue;
    }

    /**
     * 创建
     * @param name
     * @param value
     * @param expiredTime
     * @param httpOnlyState
     */
    private static void createCookie(String name, String value, int expiredTime, boolean httpOnlyState) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(expiredTime);
        cookie.setHttpOnly(httpOnlyState);
        response.addCookie(cookie);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, String value) {
        createCookie(name, value, COOKIE_MAX_AGE, HTTP_ONLY_STATE);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, String value, int expiredTime) {
        createCookie(name, value, expiredTime, HTTP_ONLY_STATE);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, String value, boolean httpOnlyState) {
        createCookie(name, value, COOKIE_MAX_AGE, httpOnlyState);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, String value, int expiredTime, boolean httpOnlyState) {
        createCookie(name, value, expiredTime, httpOnlyState);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, HashMap<String, Object> hashMap) {
        String value = JsonHelper.toJson(hashMap);
        createCookie(name, value, COOKIE_MAX_AGE, HTTP_ONLY_STATE);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, HashMap<String, Object> hashMap, int expiredTime) {
        String value = JsonHelper.toJson(hashMap);
        createCookie(name, value, expiredTime, HTTP_ONLY_STATE);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, HashMap<String, Object> hashMap, boolean httpOnlyState) {
        String value = JsonHelper.toJson(hashMap);
        createCookie(name, value, COOKIE_MAX_AGE, httpOnlyState);
    }

    /**
     * 设置cookie
     */
    public static void setCookie(String name, HashMap<String, Object> hashMap, int expiredTime, boolean httpOnlyState) {
        String value = JsonHelper.toJson(hashMap);
        createCookie(name, value, expiredTime, httpOnlyState);
    }
}
