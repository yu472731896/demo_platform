package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.SysRoleRelationDAO;
import com.minghui.demo.entity.defaults.model.SysRoleRelation;
import com.minghui.demo.entity.defaults.model.SysRoleRelationExample;

/**
 * 后台用户和角色关系表服务类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
public interface SysRoleRelationService extends BaseService<Long, SysRoleRelation, SysRoleRelationExample, SysRoleRelationDAO> {
}