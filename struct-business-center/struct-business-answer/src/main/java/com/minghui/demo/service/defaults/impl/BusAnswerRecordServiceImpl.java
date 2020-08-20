package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.BusAnswerRecordDAO;
import com.minghui.demo.entity.defaults.model.BusAnswerRecord;
import com.minghui.demo.entity.defaults.model.BusAnswerRecordExample;
import com.minghui.demo.service.defaults.BusAnswerRecordService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 答题记录服务实现类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Service("busAnswerRecordService")
public class BusAnswerRecordServiceImpl extends BaseServiceImpl<Long, BusAnswerRecord, BusAnswerRecordExample, BusAnswerRecordDAO> implements BusAnswerRecordService {


    /**
     * 答题记录批量插入
     * @param records 答题记录对象列表
     * @return 成功插入答题记录数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<BusAnswerRecord> records) {
        for (BusAnswerRecord record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}