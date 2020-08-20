package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.SysRole;
import com.minghui.demo.entity.defaults.model.SysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 后台用户角色表DAO接口类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
public interface SysRoleDAO extends BaseDAO<Long, SysRole, SysRoleExample> {
    
    /**
     * 后台用户角色表批量插入
     * @param records 后台用户角色表对象列表
     * @return 成功插入后台用户角色表数量
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<SysRole> records);
}