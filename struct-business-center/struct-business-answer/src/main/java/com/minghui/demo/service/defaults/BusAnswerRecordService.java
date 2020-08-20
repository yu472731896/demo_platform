package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.BusAnswerRecordDAO;
import com.minghui.demo.entity.defaults.model.BusAnswerRecord;
import com.minghui.demo.entity.defaults.model.BusAnswerRecordExample;

/**
 * 答题记录服务类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusAnswerRecordService extends BaseService<Long, BusAnswerRecord, BusAnswerRecordExample, BusAnswerRecordDAO> {
}