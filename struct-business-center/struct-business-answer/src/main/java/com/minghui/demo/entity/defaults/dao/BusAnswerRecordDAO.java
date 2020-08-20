package com.minghui.demo.entity.defaults.dao;

import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.demo.entity.defaults.model.BusAnswerRecord;
import com.minghui.demo.entity.defaults.model.BusAnswerRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 答题记录DAO接口类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusAnswerRecordDAO extends BaseDAO<Long, BusAnswerRecord, BusAnswerRecordExample> {
    
    /**
     * 答题记录批量插入
     * @param records 答题记录对象列表
     * @return 成功插入答题记录数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    int insertBatch(@Param("records") List<BusAnswerRecord> records);
}