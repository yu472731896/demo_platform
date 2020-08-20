package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.SysRoleDAO;
import com.minghui.demo.entity.defaults.model.SysRole;
import com.minghui.demo.entity.defaults.model.SysRoleExample;

/**
 * 后台用户角色表服务类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
public interface SysRoleService extends BaseService<Long, SysRole, SysRoleExample, SysRoleDAO> {
}