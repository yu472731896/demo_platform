package com.minghui.demo.entity.custom.dao;

import com.minghui.demo.entity.defaults.model.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mh
 * @version 1.0
 * @description TODO
 * @date 2020/8/17 10:54
 **/
public interface SysRoleRelationCustomDao {

    List<SysPermission> getPermissionList(@Param("userId") Long userId);
}
