package com.minghui.util.constant;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 09:25 2019-03-13
 * @Modified By:
 */
public interface SecurityConstants {

    /**
     * 缓存client的redis key，这里是hash结构存储
     */
    String CACHE_CLIENT_KEY = "oauth_client_details";

    /**
     * 授权方式
     */
    String OAUTH_GRANT_TYPE = "grant_type";

    /**
     * 授权方式:密码
     */
    String OAUTH_GRANT_TYPE_PASSWORD_VALUE = "password";

    /**
     * 统一的token名称
     */
    String X_AUTHORIZATION = "Authorization";

    /**
     * url拼接的时候的样式
     */
    String ACCESS_TOKEN = "access_token";

    /**
     * 用户消息头
     */
    String USER_HEARDER = "x-user-hearder";

    /**
     * 角色消息头
     */
    String ROLE_HEARDER = "x-role-hearder";

    /**
     * 超级管理员的账号
     */
    String ADMIN_USER_NAME = "admin";

    /**
     * OAUTH模式登录处理地址
     */
    String OAUTH_LOGIN_URL = "/user/login";

    /**
     * PASSWORD模式登录处理地址
     */
    String PASSWORD_LOGIN_URL = "/oauth/web/login";

    /**
     * 登录地址
     */
    String LOGIN_PAGE = "/login.html";

    String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
}
