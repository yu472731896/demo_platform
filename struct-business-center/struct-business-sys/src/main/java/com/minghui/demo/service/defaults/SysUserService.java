package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.SysUserDAO;
import com.minghui.demo.entity.defaults.model.SysUser;
import com.minghui.demo.entity.defaults.model.SysUserExample;

/**
 * 后台用户表服务类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
public interface SysUserService extends BaseService<Long, SysUser, SysUserExample, SysUserDAO> {
}