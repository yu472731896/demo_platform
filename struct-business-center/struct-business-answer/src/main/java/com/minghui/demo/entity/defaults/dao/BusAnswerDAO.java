package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.BusAnswer;
import com.minghui.demo.entity.defaults.model.BusAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 答案DAO接口类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusAnswerDAO extends BaseDAO<Long, BusAnswer, BusAnswerExample> {
    
    /**
     * 答案批量插入
     * @param records 答案对象列表
     * @return 成功插入答案数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<BusAnswer> records);
}