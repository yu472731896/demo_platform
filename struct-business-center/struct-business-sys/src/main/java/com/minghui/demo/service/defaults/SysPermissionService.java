package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.SysPermissionDAO;
import com.minghui.demo.entity.defaults.model.SysPermission;
import com.minghui.demo.entity.defaults.model.SysPermissionExample;

/**
 * 后台用户权限表服务类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
public interface SysPermissionService extends BaseService<Long, SysPermission, SysPermissionExample, SysPermissionDAO> {
}