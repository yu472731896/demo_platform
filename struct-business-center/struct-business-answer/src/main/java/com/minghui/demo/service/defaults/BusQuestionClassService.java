package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.BusQuestionClassDAO;
import com.minghui.demo.entity.defaults.model.BusQuestionClass;
import com.minghui.demo.entity.defaults.model.BusQuestionClassExample;

/**
 * 题目类别服务类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusQuestionClassService extends BaseService<Long, BusQuestionClass, BusQuestionClassExample, BusQuestionClassDAO> {
}