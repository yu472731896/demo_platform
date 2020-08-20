package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.SysPermissionRelationDAO;
import com.minghui.demo.entity.defaults.model.SysPermissionRelation;
import com.minghui.demo.entity.defaults.model.SysPermissionRelationExample;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)服务类
 * @author ThinkPad 2020-08-17 10:38
 * @since 1.0.0
 */
public interface SysPermissionRelationService extends BaseService<Long, SysPermissionRelation, SysPermissionRelationExample, SysPermissionRelationDAO> {
}