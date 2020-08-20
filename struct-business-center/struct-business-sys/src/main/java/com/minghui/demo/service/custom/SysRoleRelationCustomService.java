package com.minghui.demo.service.custom;

import com.minghui.demo.entity.defaults.model.SysPermission;
import com.minghui.demo.service.defaults.SysRoleRelationService;

import java.util.List;

public interface SysRoleRelationCustomService extends SysRoleRelationService {

    List<SysPermission> getPermissionList(Long adminId);
}
