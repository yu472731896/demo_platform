package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.BusMember;
import com.minghui.demo.entity.defaults.model.BusMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表DAO接口类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusMemberDAO extends BaseDAO<Long, BusMember, BusMemberExample> {
    
    /**
     * 用户表批量插入
     * @param records 用户表对象列表
     * @return 成功插入用户表数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<BusMember> records);
}