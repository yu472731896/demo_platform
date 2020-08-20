package com.minghui.util.utils;

import com.minghui.common.UserSessionInfo;
import com.minghui.util.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.session.ExpiringSession;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Classname:SSOUserUtils
 * @Auther:chenqinglin
 * @Date:2019/1/11 14:03
 * @Version: 1.0
 */
@Slf4j
public class SSOUserUtils {

    public static final String OTHER_SESSION_NAME = "HSP_SESSION_ID";

    public static final String OTHER_USER_SESSION_KEY = "userSessionInfo";

    /**
     * @description:<p>[获取微服务登录的用户信息]</p>
     *
     * @param:
     * @return:com.ropeok.security.model.LoginUserInfo
     * @auther: chenqinglin
     * @date: 2019/1/11 14:07
     */
    public static LoginUserInfo getLoginUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof OAuth2Authentication){
                OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
                authentication = oAuth2Authentication.getUserAuthentication();
                if (authentication instanceof UsernamePasswordAuthenticationToken){
                    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
                    return (LoginUserInfo) token.getPrincipal();
                }
            }else if (authentication instanceof PreAuthenticatedAuthenticationToken){
                PreAuthenticatedAuthenticationToken token = (PreAuthenticatedAuthenticationToken) authentication;
                return (LoginUserInfo) token.getPrincipal();
            }
        }
        return null;
    }

    /**
     * @description:<p>[获取老系统登录的用户信息]</p>
     *
     * @param: redisTemplate
     * @return:com.ropeok.common.UserSessionInfo
     * @auther: chenqinglin
     * @date: 2019/1/11 14:25
     */
    public static UserSessionInfo getOldSystemLoginUserInfo(RedisTemplate redisTemplate){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null){
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
            request = servletRequestAttributes.getRequest();
            if (request != null){
                Cookie[] cookies = request.getCookies();
                if (ArrayUtils.isNotEmpty(cookies)){
                    Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(c -> StringUtils.equals(c.getName(),OTHER_SESSION_NAME)).findFirst();
                    if (optionalCookie.get() != null){
                        RedisOperationsSessionRepository repository = new RedisOperationsSessionRepository(redisTemplate);
                        Object object = repository.findById(optionalCookie.get().getValue());
                        UserSessionInfo userSessionInfo = ((ExpiringSession)object).getAttribute(OTHER_USER_SESSION_KEY);
                        return userSessionInfo;
                    }
                }
            }
        }
        return null;
    }
}
