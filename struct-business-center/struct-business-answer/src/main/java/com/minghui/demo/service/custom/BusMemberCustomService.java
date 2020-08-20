package com.minghui.demo.service.custom;

import com.alibaba.fastjson.JSONObject;
import com.minghui.common.framework.model.PageResult;
import com.minghui.demo.entity.custom.vo.TokenVO;
import com.minghui.demo.entity.defaults.model.BusMember;
import com.minghui.demo.service.defaults.BusMemberService;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户表服务类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusMemberCustomService extends BusMemberService {

    BusMember loginByWeixin(HttpServletRequest request);

    TokenVO login(String username, String password);

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @author mh
     * @date 2020/8/20 15:29
     * @return UserDetails
     **/
    UserDetails loadUserByUsername(String username);
}