package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.SysPermissionRelation;
import com.minghui.demo.entity.defaults.model.SysPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)DAO接口类
 * @author ThinkPad 2020-08-17 10:38
 * @since 1.0.0
 */
public interface SysPermissionRelationDAO extends BaseDAO<Long, SysPermissionRelation, SysPermissionRelationExample> {
    
    /**
     * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)批量插入
     * @param records 后台用户和权限关系表(除角色中定义的权限以外的加减权限)对象列表
     * @return 成功插入后台用户和权限关系表(除角色中定义的权限以外的加减权限)数量
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<SysPermissionRelation> records);
}