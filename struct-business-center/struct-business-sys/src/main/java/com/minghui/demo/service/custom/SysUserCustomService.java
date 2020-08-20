package com.minghui.demo.service.custom;

import com.minghui.demo.entity.custom.dto.SysUserParam;
import com.minghui.demo.entity.defaults.model.SysUser;
import com.minghui.demo.service.defaults.SysUserService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author mh
 * @version 1.0
 * @description TODO
 * @date 2020/8/17 10:09
 **/
public interface SysUserCustomService extends SysUserService {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    SysUser getUserByUsername(String username);

    /**
     * 添加用户
     * @param sysUserParam
     * @author mh
     * @date 2020/8/18 11:36
     * @return boolean
      **/
    boolean insertUser(SysUserParam sysUserParam);

    /**
     * 验证用户名称是否存在
     * @param userName
     * @author mh
     * @date 2020/8/18 11:43
     * @return boolean
      **/
    boolean checkUserName(String userName);
}
