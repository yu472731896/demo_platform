package com.minghui.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.minghui.common.framework.model.PageResult;
import com.minghui.demo.entity.custom.bo.MemberDetails;
import com.minghui.demo.entity.custom.dto.UmsAdminLoginParam;
import com.minghui.demo.entity.custom.vo.TokenVO;
import com.minghui.demo.entity.defaults.model.BusMember;
import com.minghui.demo.service.custom.BusMemberCustomService;
import com.minghui.util.LoginUserInfo;
import com.minghui.util.utils.SSOUserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mh
 * @version 1.0
 * @description 用户管理
 * @date 2020/8/20 15:08
 **/
@RestController
@Api(tags = "BusMemberController", description = "用户管理")
@RequestMapping("/member")
@Slf4j
public class BusMemberController {

    @Autowired
    private BusMemberCustomService busMemberCustomService;

    @ApiOperation(value = "微信登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public PageResult login(String username, String password) {
        PageResult result = null;
        try {
            TokenVO token = busMemberCustomService.login(username, password);
            result = PageResult.ok(token);
        } catch (Exception e) {
            log.error("");
        }
        return result;
    }

    @ApiOperation(value = "")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public PageResult test(String username, String password) {
        PageResult result = null;
        try {
            MemberDetails memberDetails = getLoginUser();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
           return PageResult.ok(memberDetails);
        } catch (Exception e) {
            log.error("e", e);
        }
        return result;
    }

    @ApiOperation(value = "微信登录")
    @RequestMapping(value = "/login/weixin", method = RequestMethod.POST)
    public PageResult login(HttpServletRequest request) {
        PageResult result = null;
        try {
           BusMember busMember = busMemberCustomService.loginByWeixin(request);
            result = PageResult.ok(busMember);
        } catch (Exception e) {
            log.error("");
        }
        return result;
    }

    private MemberDetails getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof UsernamePasswordAuthenticationToken){
                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
                return (MemberDetails) token.getPrincipal();
            }else if (authentication instanceof PreAuthenticatedAuthenticationToken){
                PreAuthenticatedAuthenticationToken token = (PreAuthenticatedAuthenticationToken) authentication;
                return (MemberDetails) token.getPrincipal();
            }
        }
        return null;
    }
}
