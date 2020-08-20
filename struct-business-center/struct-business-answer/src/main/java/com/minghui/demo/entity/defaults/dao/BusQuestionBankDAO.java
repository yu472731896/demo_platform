package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.BusQuestionBank;
import com.minghui.demo.entity.defaults.model.BusQuestionBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 题目DAO接口类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusQuestionBankDAO extends BaseDAO<Long, BusQuestionBank, BusQuestionBankExample> {
    
    /**
     * 题目批量插入
     * @param records 题目对象列表
     * @return 成功插入题目数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<BusQuestionBank> records);
}