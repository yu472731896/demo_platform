package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.SysPermission;
import com.minghui.demo.entity.defaults.model.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 后台用户权限表DAO接口类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
public interface SysPermissionDAO extends BaseDAO<Long, SysPermission, SysPermissionExample> {
    
    /**
     * 后台用户权限表批量插入
     * @param records 后台用户权限表对象列表
     * @return 成功插入后台用户权限表数量
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<SysPermission> records);
}