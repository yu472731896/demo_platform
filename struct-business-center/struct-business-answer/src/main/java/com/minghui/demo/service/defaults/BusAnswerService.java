package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.BusAnswerDAO;
import com.minghui.demo.entity.defaults.model.BusAnswer;
import com.minghui.demo.entity.defaults.model.BusAnswerExample;

/**
 * 答案服务类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusAnswerService extends BaseService<Long, BusAnswer, BusAnswerExample, BusAnswerDAO> {
}