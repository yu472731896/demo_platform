package com.minghui.util.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:chenql
 * @Description: 获取当前请求的request和response对象
 * @Date:Created in 15:19 2019-02-20
 * @Modified By:
 */
public class RequestAndResponseContextUtils {

    public static final String RESPONSE_NAME_AT_ATTRIBUTES = ServletRequestAttributes.class.getName() + ".ATTRIBUTE_NAME";

    public static final HttpServletResponse response() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = null;
        if (attributes != null) {
            ServletRequestAttributes var2 = (ServletRequestAttributes)attributes;
            response = (HttpServletResponse)var2.getAttribute(RESPONSE_NAME_AT_ATTRIBUTES, 0);
        }

        return response;
    }

    public static final HttpServletRequest request() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            ServletRequestAttributes var2 = (ServletRequestAttributes)attributes;
            request = var2.getRequest();
        }
        return request;
    }
}
