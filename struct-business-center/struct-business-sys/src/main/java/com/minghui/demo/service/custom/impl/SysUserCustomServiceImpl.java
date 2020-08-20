package com.minghui.demo.service.custom.impl;

import com.minghui.demo.entity.custom.bo.AdminUserDetails;
import com.minghui.demo.entity.custom.dto.SysUserParam;
import com.minghui.demo.entity.defaults.model.SysPermission;
import com.minghui.demo.entity.defaults.model.SysUser;
import com.minghui.demo.service.custom.SysRoleRelationCustomService;
import com.minghui.demo.service.custom.SysUserCustomService;
import com.minghui.demo.service.defaults.impl.SysUserServiceImpl;
import com.minghui.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.minghui.demo.entity.defaults.model.SysUserExample;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mh
 * @version 1.0
 * @description 系统用户业务实现类（自定义）
 * @date 2020/8/17 10:10
 **/
@Slf4j
@Service
public class SysUserCustomServiceImpl extends SysUserServiceImpl implements SysUserCustomService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SysRoleRelationCustomService sysRoleRelationCustomService;

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.error("登录异常:{}", e);
        }
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        SysUser admin = getUserByUsername(username);
        if (admin != null) {
            List<SysPermission> permissionList = getPermissionList(admin.getId());
            return new AdminUserDetails(admin,permissionList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public SysUser getUserByUsername(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> adminList = selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    /**
     * 添加用户
     * @param sysUserParam
     * @return boolean
     * @author mh
     * @date 2020/8/18 11:36
     **/
    @Override
    public boolean insertUser(SysUserParam sysUserParam) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserParam, sysUser);
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(sysUserParam.getPassword());
        sysUser.setPassword(encodePassword);
        return insertSelective(sysUser) > 0;
    }

    /**
     * 验证用户名称是否存在
     * @param userName 用户名称
     * @return boolean
     * @author mh
     * @date 2020/8/18 11:43
     **/
    @Override
    public boolean checkUserName(String userName) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(userName).andIsDeleteEqualTo(false);
        return countByExample(example) > 0;
    }

    public List<SysPermission> getPermissionList(Long adminId) {
        return sysRoleRelationCustomService.getPermissionList(adminId);
    }
}
