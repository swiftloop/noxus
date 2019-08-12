package com.noxus.web.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sorata
 * @date 2019-08-01 17:50
 */
public class WebUtils {

    private WebUtils(){}



    public static HttpServletRequest request(){
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            if (attributes != null){
                return attributes.getRequest();
            }
        } catch (Exception e) {
           //
        }
        return null;
    }


    public static String getBasePath(HttpServletRequest request){
        if (request == null) { return "";}
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }



    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && !isValidAddress(ip)) {
            ip = null;
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            if (ip != null && !isValidAddress(ip)) {
                ip = null;
            }
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            if (ip != null && !isValidAddress(ip)) {
                ip = null;
            }
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            if (ip != null && !isValidAddress(ip)) {
                ip = null;
            }
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip != null && !isValidAddress(ip)) {
                ip = null;
            }
        }

        return ip == null ? "0.0.0.0" : ip;
    }

    private static boolean isValidAddress(String ip) {
        if (ip == null) {
            return false;
        }

        for (int i = 0; i < ip.length(); ++i) {
            char ch = ip.charAt(i);
            if (ch >= '0' && ch <= '9') {
            } else if (ch >= 'A' && ch <= 'F') {
            } else if (ch >= 'a' && ch <= 'f') {
            } else if (ch == '.' || ch == ':') {
                //
            } else {
                return false;
            }
        }

        return true;
    }



}
