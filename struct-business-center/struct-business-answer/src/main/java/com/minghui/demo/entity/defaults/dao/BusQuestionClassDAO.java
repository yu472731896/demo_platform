package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.BusQuestionClass;
import com.minghui.demo.entity.defaults.model.BusQuestionClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 题目类别DAO接口类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusQuestionClassDAO extends BaseDAO<Long, BusQuestionClass, BusQuestionClassExample> {
    
    /**
     * 题目类别批量插入
     * @param records 题目类别对象列表
     * @return 成功插入题目类别数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<BusQuestionClass> records);
}